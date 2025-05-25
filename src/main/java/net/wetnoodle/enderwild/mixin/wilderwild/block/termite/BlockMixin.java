package net.wetnoodle.enderwild.mixin.wilderwild.block.termite;

import net.frozenblock.lib.FrozenBools;
import net.frozenblock.wilderwild.config.WWBlockConfig;
import net.frozenblock.wilderwild.registry.WWBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;

@Mixin(value = Block.class)
public class BlockMixin {
    @Unique
    private static final boolean WILDERWILD$TERMITE_NATURAL_BLOCKS_ON_BOOT = WWBlockConfig.get().termite.onlyEatNaturalBlocks;

    @Unique
    private static final List<String> ENDERWILD$TERMITE_EDIBLE = Arrays.asList(new String[]{"block.enderscape.celestial_cap"});

    @Inject(method = "createBlockStateDefinition", at = @At("TAIL"))
    private void addTermiteEdibleState(StateDefinition.Builder<Block, BlockState> builder, CallbackInfo info) {
        if (FrozenBools.IS_DATAGEN || !WILDERWILD$TERMITE_NATURAL_BLOCKS_ON_BOOT) return;
        BlockBehaviour blockBehaviour = Block.class.cast(this);
        if (ENDERWILD$TERMITE_EDIBLE.contains(blockBehaviour.descriptionId)) {
            builder.add(WWBlockStateProperties.TERMITE_EDIBLE);
        }
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void wilderWild$appendFalseTermiteEdibleToState(BlockBehaviour.Properties properties, CallbackInfo info) {
        if (FrozenBools.IS_DATAGEN) return;
        Block block = Block.class.cast(this);
        BlockState defaultBlockState = block.defaultBlockState();
        if (defaultBlockState.hasProperty(WWBlockStateProperties.TERMITE_EDIBLE)) {
            block.registerDefaultState(defaultBlockState.setValue(WWBlockStateProperties.TERMITE_EDIBLE, false));
        }
    }
}
