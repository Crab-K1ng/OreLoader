package io.github.CrabK1ng.OreLoader;

import com.badlogic.gdx.utils.*;
import finalforeach.cosmicreach.GameAssetLoader;

public class LoadOres {
    public static final Array<OreList> allOre = new Array<>();

    public static void loadOres() {
        GameAssetLoader.forEachAsset("worldgen/ores", ".json", (p, f) -> {
            try {
                Constants.LOGGER.info("Loading: " + p);
                loadOre(GameAssetLoader.loadJson(f),p);
            } catch (Exception var3) {
                throw new RuntimeException("Error parsing ores: " + p, var3);
            }
        });
    }

    private static void loadOre(JsonValue loadJson,String p) {
        OreList Ore = new OreList();
        JsonValue oreToLoad = loadJson.get("ore");

        if (!oreToLoad.has("block")) {
            throw new NullPointerException("block field is missing in: " + p );
        }

        String blockId = oreToLoad.getString("block");
        Constants.LOGGER.info("adding: " + blockId);

        int MaxElevation = oreToLoad.has("MaxElevation") ? oreToLoad.getInt("MaxElevation") : 1073741823;
        int MinElevation = oreToLoad.has("MinElevation") ? oreToLoad.getInt("MinElevation") : -1073741824;
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
