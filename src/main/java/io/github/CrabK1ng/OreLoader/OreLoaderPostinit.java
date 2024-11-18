package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.core.loader.provider.mod.entrypoint.impls.PostModInitializer;

public class OreLoaderPostinit implements PostModInitializer {

    @Override
    public void onPostInit() {
        LoadOres.loadOres();
    }
}
