package io.github.CrabK1ng.OreLoader.mixins;

import finalforeach.cosmicreach.blocks.Block;
import finalforeach.cosmicreach.worldgen.Ore;
import io.github.CrabK1ng.OreLoader.Constants;
import io.github.CrabK1ng.OreLoader.OreList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.CrabK1ng.OreLoader.LoadOres.allOre;

@Mixin(Ore.class)
public class OreMixin {

    @Inject(method = "init", at = @At("TAIL"))
    private static void init(CallbackInfo ci) {
        Constants.LOGGER.info("Ores");

        for(OreList r : allOre) {
            Ore tempOre;
            Constants.LOGGER.info("blockId " + r.blockId);
            tempOre = (new Ore(Block.getById(r.blockId).getDefaultBlockState(), "ore_replaceable"))
                    .setMinElevation(r.MinElevation)
                    .setMaxElevation(r.MaxElevation)
                    .setMaxOresPerCluster(r.MaxOresPerCluster)
                    .setAttemptsPerColumn(r.AttemptsPerColumn);
        }

    }

}
