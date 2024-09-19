package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.loader.entrypoint.interfaces.PostModInitializer;

public class OreLoaderPostinit implements PostModInitializer {

    @Override
    public void onPostInit() {
        LoadOres.loadOres();
    }
}
