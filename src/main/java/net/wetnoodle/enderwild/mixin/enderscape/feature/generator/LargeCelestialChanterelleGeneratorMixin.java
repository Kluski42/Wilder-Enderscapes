package net.wetnoodle.enderwild.mixin.enderscape.feature.generator;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.bunten.enderscape.feature.generator.LargeCelestialChanterelleGenerator;
import net.frozenblock.wilderwild.block.TermiteMoundBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LargeCelestialChanterelleGenerator.class)
public class LargeCelestialChanterelleGeneratorMixin {
    @ModifyExpressionValue(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;defaultBlockState()Lnet/minecraft/world/level/block/state/BlockState;", ordinal = 2))
    private static BlockState enderWild$setTermiteEdible(BlockState state) {
        return TermiteMoundBlock.setTermiteEdibleIfPossible(state);
    }
}
