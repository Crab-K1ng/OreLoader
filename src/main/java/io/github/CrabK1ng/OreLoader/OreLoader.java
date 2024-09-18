package io.github.CrabK1ng.OreLoader;

import com.github.puzzle.core.PuzzleRegistries;
import com.github.puzzle.core.localization.ILanguageFile;
import com.github.puzzle.core.localization.LanguageManager;
import com.github.puzzle.core.localization.files.LanguageFileVersion1;
import com.github.puzzle.core.resources.PuzzleGameAssetLoader;
import com.github.puzzle.game.block.DataModBlock;
import com.github.puzzle.game.events.OnPreLoadAssetsEvent;
import com.github.puzzle.game.events.OnRegisterBlockEvent;
import com.github.puzzle.game.events.OnRegisterZoneGenerators;
import com.github.puzzle.game.items.IModItem;
import com.github.puzzle.game.items.impl.BasicItem;
import com.github.puzzle.game.items.impl.BasicTool;
import com.github.puzzle.loader.entrypoint.interfaces.ModInitializer;
import finalforeach.cosmicreach.util.Identifier;
import io.github.CrabK1ng.OreLoader.blocks.Bedrock;
import io.github.CrabK1ng.OreLoader.commands.Commands;
import io.github.CrabK1ng.OreLoader.items.ExampleCyclingItem;
import io.github.CrabK1ng.OreLoader.items.ExamplePickaxe;
import io.github.CrabK1ng.OreLoader.worldgen.ExampleZoneGenerator;
import io.github.CrabK1ng.OreLoader.block_entities.ExampleBlockEntity;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.Objects;

public class OreLoader implements ModInitializer {

    @Override
    public void onInit() {
        PuzzleRegistries.EVENT_BUS.register(this);

        Constants.LOGGER.info("Hello From INIT");
    }

    @Subscribe
    public void onEvent(OnRegisterZoneGenerators event) {
    }

    @Subscribe
    public void onEvent(OnPreLoadAssetsEvent event) {
    }
}
