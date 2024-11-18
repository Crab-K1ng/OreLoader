package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.core.loader.provider.mod.entrypoint.impls.ModInitializer;

public class OreLoader implements ModInitializer {

    @Override
    public void onInit() {
        Constants.LOGGER.info("Hello From INIT");
    }
}
