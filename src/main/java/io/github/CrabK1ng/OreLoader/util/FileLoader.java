package io.github.CrabK1ng.OreLoader.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import finalforeach.cosmicreach.io.SaveLocation;
import finalforeach.cosmicreach.util.AnsiColours;
import finalforeach.cosmicreach.util.Identifier;

import java.util.HashSet;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

public class FileLoader {

    public static FileHandle loadAsset(Identifier location) {
        FileHandle modLocationFile = Gdx.files.absolute(SaveLocation.getSaveFolderLocation() + "/mods/" + location.toPath());
        if (modLocationFile.exists()) {
            System.out.println("Loading " + AnsiColours.CYAN + "\"" + location.getName() + "\"" + AnsiColours.RESET + " from Mods Folder");
            return modLocationFile;
        } else {
            FileHandle classpathLocationFile = Gdx.files.classpath("assets/%s/%s".formatted(location.getNamespace(), location.getName()));
            if (classpathLocationFile.exists()) {
                System.out
                        .println(
                                "Loading "
                                        + AnsiColours.PURPLE
                                        + "\""
                                        + location.getName()
                                        + "\""
                                        + AnsiColours.RESET
                                        + " from Java Mod "
                                        + AnsiColours.GREEN
                                        + "\""
                                        + location.getNamespace()
                                        + "\""
                                        + AnsiColours.WHITE
                        );
                return classpathLocationFile;
            } else {
                FileHandle vanillaLocationFile = Gdx.files.internal(location.toPath());
                if (vanillaLocationFile.exists()) {
                    System.out.println("Loading " + AnsiColours.YELLOW + "\"" + location.getName() + "\"" + AnsiColours.RESET + " from Cosmic Reach");
                    return vanillaLocationFile;
                } else {
                    System.out.println("Cannot find the resource " + location + " (Expected path: " + location.toPath() + ")");
                    return null;
                }
            }
        }
    }

    public static void forEachAsset(String prefix, String extension, BiConsumer<String, FileHandle> assetConsumer) {
        forEachAsset(prefix, extension, assetConsumer, false);
    }

    public static void forEachAsset(String prefix, String extension, BiConsumer<String, FileHandle> assetConsumer, boolean includeDirectories) {
        HashSet<Identifier> allPaths = new HashSet<>();

        HashSet<Identifier> moddedPaths = new HashSet<>();
        String modAssetFolder = SaveLocation.getSaveFolderLocation() + "/mods/";
        String modAssetRoot = Gdx.files.absolute(modAssetFolder).path().replace("\\", "/");

        for(FileHandle modFolder : Gdx.files.absolute(modAssetRoot).list()) {
            if (modFolder.isDirectory() || includeDirectories) {
                String postPrefix = prefix;
                if (prefix.startsWith(modFolder.file().getName() + ":")) {
                    postPrefix = prefix.substring(modFolder.file().getName().length() + 1);
                }

                String modPrefix = modFolder + "/" + postPrefix;
                modPrefix = modPrefix.replace("\\", "/");
                FileHandle[] moddedAssetDir = Gdx.files.absolute(modPrefix).list();

                for(FileHandle asset : moddedAssetDir) {
                    String assetPath = asset.path().replace("\\", "/").replace(modAssetRoot, "");
                    if (assetPath.startsWith("/")) {
                        assetPath = assetPath.substring(1);
                    }

                    String namespace = modFolder.name();
                    String name = assetPath.replaceFirst(Pattern.quote(namespace + "/"), "");
                    if (name.startsWith(postPrefix) && assetPath.endsWith(extension)) {
                        moddedPaths.add(Identifier.of(namespace, name));
                    }
                }
            }
        }

        allPaths.addAll(moddedPaths);

        for(Identifier path : allPaths) {
            assetConsumer.accept(path.toString(), loadAsset(path));
        }
    }
}
