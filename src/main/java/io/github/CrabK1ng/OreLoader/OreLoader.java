package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.loader.entrypoint.interfaces.ModInitializer;

public class OreLoader implements ModInitializer {

    @Override
    public void onInit() {
        Constants.LOGGER.info("Hello From INIT");
    }
}
