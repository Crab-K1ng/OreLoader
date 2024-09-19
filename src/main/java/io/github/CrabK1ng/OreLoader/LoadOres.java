package io.github.CrabK1ng.OreLoader;

import com.badlogic.gdx.utils.*;
import finalforeach.cosmicreach.GameAssetLoader;
import finalforeach.cosmicreach.blocks.Block;
import io.github.CrabK1ng.OreLoader.util.FileLoader;

public class LoadOres {
    public static final Array<OreList> allOre = new Array<>();

    // did not work for some reason
//    public static void loadOres() {
//        Constants.LOGGER.info("it starts");
//        GameAssetLoader.forEachAsset("worldgen/ores", ".json", (p, f) -> {
//            try {
//                Constants.LOGGER.info("it starts2");
//                Constants.LOGGER.info(f);
//                Constants.LOGGER.info(p);
//                loadOre(GameAssetLoader.loadJson(f));
//            } catch (Exception var3) {
//                throw new RuntimeException("Error parsing ores: " + p, var3);
//            }
//        });
//    }

    public static void loadOres() {
        FileLoader.forEachAsset("worldgen/ores", ".json", (p, f) -> {
            try {
                Constants.LOGGER.info("Loading: " + p);
                loadOre(GameAssetLoader.loadJson(f));
            } catch (Exception var3) {
                throw new RuntimeException("Error parsing ores: " + p, var3);
            }
        });
    }

    private static void loadOre(JsonValue loadJson) {
        OreList Ore = new OreList();
        JsonValue oreToLoad = loadJson.get("ore");

        String blockId = oreToLoad.getString("block");
        Constants.LOGGER.info("blockId: " + blockId);

        Block block = Block.getById(blockId);
        if (block == null) {
            throw new NullPointerException("Missing block for id: " + blockId);
        }

        int MaxElevation = oreToLoad.has("MaxElevation") ? oreToLoad.getInt("MaxElevation") : 1;
        int MinElevation = oreToLoad.has("MinElevation") ? oreToLoad.getInt("MinElevation") : 1;
        int MaxOresPerCluster = oreToLoad.has("MaxOresPerCluster") ? oreToLoad.getInt("MaxOresPerCluster") : 1;
        int AttemptsPerColumn = oreToLoad.has("AttemptsPerColumn") ? oreToLoad.getInt("AttemptsPerColumn") : 1;
        Ore.setOre(blockId, MaxElevation, MinElevation, MaxOresPerCluster, AttemptsPerColumn);
        registerOre(Ore);
    }

    public static void registerOre(OreList Ore) {
        if (Ore.isEmpty()) {
            throw new RuntimeException("Ore cannot be empty!");
        } else {
            allOre.add(Ore);
        }
    }
}
