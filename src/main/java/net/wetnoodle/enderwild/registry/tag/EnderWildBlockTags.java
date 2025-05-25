package net.wetnoodle.enderwild.registry.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.wetnoodle.enderwild.EnderWildConstants;

public final class EnderWildBlockTags {

    public static final TagKey<Block> HOLLOWED_CELESTIAL_STEMS = register("hollowed_celestial_stems");
    public static final TagKey<Block> HOLLOWED_MURUBLIGHT_STEMS = register("hollowed_murublight_stems");
    public static final TagKey<Block> HOLLOWED_VEILED_LOGS = register("hollowed_veiled_logs");

    private EnderWildBlockTags() {
        throw new UnsupportedOperationException("EnderWildBlockTags contains only static declarations.");
    }

    private static TagKey<Block> register(String name) {
        return TagKey.create(Registries.BLOCK, EnderWildConstants.id(name));
    }

}
