package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.loader.entrypoint.interfaces.PreModInitializer;

public class OreLoaderPreinit implements PreModInitializer {

    @Override
    public void onPreInit() {
        Constants.LOGGER.info("Hello From PRE-INIT");
    }
}
