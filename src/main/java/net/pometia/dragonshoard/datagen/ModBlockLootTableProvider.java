package net.pometia.dragonshoard.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pometia.dragonshoard.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        // METALS
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GOLD_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GOLD_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        dropSelf(ModBlocks.STAR_BLUE_GOLD_BLOCK.get());
        // CRYSTAL BLOCKS
        dropSelf(ModBlocks.MOONSTONE_CRYSTAL.get());
        dropSelf(ModBlocks.IOLITE_CRYSTAL.get());
        dropSelf(ModBlocks.AQUAMARINE_CRYSTAL.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_CRYSTAL.get());
        dropSelf(ModBlocks.VERDELITE_CRYSTAL.get());
        dropSelf(ModBlocks.ALEXANDRITE_CRYSTAL.get());
        dropSelf(ModBlocks.RUBY_CRYSTAL.get());
        dropSelf(ModBlocks.SAPPHIRE_CRYSTAL.get());
        dropSelf(ModBlocks.TOURMALINE_CRYSTAL.get());
        dropSelf(ModBlocks.TANZANITE_CRYSTAL.get());
        dropSelf(ModBlocks.CITRINE_CRYSTAL.get());
        dropSelf(ModBlocks.OPAL_CRYSTAL.get());
        // GEM BLOCKS
        dropSelf(ModBlocks.MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.IOLITE_BLOCK.get());
        dropSelf(ModBlocks.AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.CITRINE_BLOCK.get());
        dropSelf(ModBlocks.OPAL_BLOCK.get());
        // GILDED GEM BLOCKS
        dropSelf(ModBlocks.GOLDEN_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_MOONSTONE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_IOLITE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_AQUAMARINE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_VERDELITE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_TOURMALINE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_TANZANITE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_CITRINE_BLOCK.get());
        dropSelf(ModBlocks.GOLDEN_GILDED_OPAL_BLOCK.get());
        dropSelf(ModBlocks.WHITE_GILDED_OPAL_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GILDED_OPAL_BLOCK.get());
        dropSelf(ModBlocks.ROSE_GILDED_OPAL_BLOCK.get());
        dropSelf(ModBlocks.STAR_GILDED_OPAL_BLOCK.get());
        dropSelf(ModBlocks.SILVER_GILDED_OPAL_BLOCK.get());
        // IDOLS
        dropSelf(ModBlocks.JAN_IDOL.get());
        dropSelf(ModBlocks.FEB_IDOL.get());
        dropSelf(ModBlocks.MAR_IDOL.get());
        dropSelf(ModBlocks.APR_IDOL.get());
        dropSelf(ModBlocks.MAY_IDOL.get());
        dropSelf(ModBlocks.JUN_IDOL.get());
        dropSelf(ModBlocks.JUL_IDOL.get());
        dropSelf(ModBlocks.AUG_IDOL.get());
        dropSelf(ModBlocks.SEP_IDOL.get());
        dropSelf(ModBlocks.OCT_IDOL.get());
        dropSelf(ModBlocks.NOV_IDOL.get());
        dropSelf(ModBlocks.DEC_IDOL.get());
        // CRYSTALS
        dropSelf(ModBlocks.MOONSTONE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.MOONSTONE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.MOONSTONE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.MOONSTONE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.IOLITE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.IOLITE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.IOLITE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.IOLITE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.AQUAMARINE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.AQUAMARINE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.AQUAMARINE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.AQUAMARINE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.VERDELITE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.VERDELITE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.VERDELITE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.VERDELITE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.ALEXANDRITE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.ALEXANDRITE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.ALEXANDRITE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.ALEXANDRITE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.RUBY_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.RUBY_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.RUBY_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.RUBY_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.SAPPHIRE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.SAPPHIRE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.SAPPHIRE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.SAPPHIRE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.TOURMALINE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.TOURMALINE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.TOURMALINE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.TOURMALINE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.TANZANITE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.TANZANITE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.TANZANITE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.TANZANITE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.CITRINE_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.CITRINE_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.CITRINE_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.CITRINE_CRYSTAL_STRUCTURE_4.get());
        dropSelf(ModBlocks.OPAL_CRYSTAL_STRUCTURE_1.get());
        dropSelf(ModBlocks.OPAL_CRYSTAL_STRUCTURE_2.get());
        dropSelf(ModBlocks.OPAL_CRYSTAL_STRUCTURE_3.get());
        dropSelf(ModBlocks.OPAL_CRYSTAL_STRUCTURE_4.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
