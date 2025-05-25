package net.wetnoodle.enderwild.datagen.tag;

import net.bunten.enderscape.registry.tag.EnderscapeBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.wilderwild.tag.WWBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.wetnoodle.enderwild.registry.tag.EnderWildBlockTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.bunten.enderscape.registry.EnderscapeBlocks.*;
import static net.wetnoodle.enderwild.registry.EnderWildBlocks.*;

public final class EnderWildBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public EnderWildBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.generateCompat();
        this.generateEnderscape();
        this.generateHollowedAndTermites();
    }

    @NotNull
    private TagKey<Block> getTag(String id) {
        return TagKey.create(this.registryKey, ResourceLocation.parse(id));
    }

    private void generateCompat() {
        this.getOrCreateTagBuilder(getTag("c:stripped_logs"))
                .add(STRIPPED_HOLLOWED_CELESTIAL_STEM)
                .add(STRIPPED_HOLLOWED_MURUBLIGHT_STEM)
                .add(STRIPPED_HOLLOWED_VEILED_LOG);
    }

    private void generateEnderscape() {
        this.getOrCreateTagBuilder(EnderscapeBlockTags.CELESTIAL_STEMS)
                .addOptionalTag(EnderWildBlockTags.HOLLOWED_CELESTIAL_STEMS);
        this.getOrCreateTagBuilder(EnderscapeBlockTags.MURUBLIGHT_STEMS)
                .addOptionalTag(EnderWildBlockTags.HOLLOWED_MURUBLIGHT_STEMS);
        this.getOrCreateTagBuilder(EnderscapeBlockTags.VEILED_LOGS)
                .addOptionalTag(EnderWildBlockTags.HOLLOWED_VEILED_LOGS);
    }

    private void generateHollowedAndTermites() {
        this.getOrCreateTagBuilder(EnderWildBlockTags.HOLLOWED_CELESTIAL_STEMS)
                .add(HOLLOWED_CELESTIAL_STEM)
                .add(STRIPPED_HOLLOWED_CELESTIAL_STEM);

        this.getOrCreateTagBuilder(EnderWildBlockTags.HOLLOWED_MURUBLIGHT_STEMS)
                .add(HOLLOWED_MURUBLIGHT_STEM)
                .add(STRIPPED_HOLLOWED_MURUBLIGHT_STEM);

        this.getOrCreateTagBuilder(EnderWildBlockTags.HOLLOWED_VEILED_LOGS)
                .add(HOLLOWED_VEILED_LOG)
                .add(STRIPPED_HOLLOWED_VEILED_LOG);

        this.getOrCreateTagBuilder(WWBlockTags.HOLLOWED_LOGS_THAT_BURN)
                .add(HOLLOWED_CELESTIAL_STEM)
                .add(HOLLOWED_MURUBLIGHT_STEM)
                .add(HOLLOWED_VEILED_LOG);

        this.getOrCreateTagBuilder(WWBlockTags.STRIPPED_HOLLOWED_LOGS_THAT_BURN)
                .add(STRIPPED_HOLLOWED_CELESTIAL_STEM)
                .add(STRIPPED_HOLLOWED_MURUBLIGHT_STEM)
                .add(STRIPPED_HOLLOWED_VEILED_LOG);

        this.getOrCreateTagBuilder(WWBlockTags.KILLS_TERMITE)
                .addOptionalTag(EnderscapeBlockTags.MURUBLIGHT_WOOD)
                .addOptionalTag(EnderscapeBlockTags.MURUBLIGHT_BRICK_BLOCKS)
                .add(CORRUPT_OVERGROWTH)
                .add(CORRUPT_GROWTH)
                .add(CORRUPT_PATH_BLOCK)
                .add(MURUBLIGHT_CHANTERELLE)
                .add(MURUBLIGHT_CAP)
                .add(MURUBLIGHT_SHELF)

                .addOptionalTag(EnderscapeBlockTags.VEILED_WOOD_TAG)
                .add(VEILED_LEAVES)
                .add(VEILED_LEAF_PILE)
                .add(VEILED_SAPLING)
                .add(VEILED_END_STONE);
    }
}