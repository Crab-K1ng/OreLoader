package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.core.PuzzleRegistries;
import com.github.puzzle.game.events.OnRegisterZoneGenerators;
import com.github.puzzle.loader.entrypoint.interfaces.ModInitializer;
import org.greenrobot.eventbus.Subscribe;

public class OreLoader implements ModInitializer {

    @Override
    public void onInit() {
        PuzzleRegistries.EVENT_BUS.register(this);

        Constants.LOGGER.info("Hello From INIT");
    }

    @Subscribe
    public void onEvent(OnRegisterZoneGenerators event) {
    }
}
