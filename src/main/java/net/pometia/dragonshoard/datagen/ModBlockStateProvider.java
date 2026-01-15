package net.pometia.dragonshoard.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DragonsHoard.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // METALS
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.WHITE_GOLD_BLOCK);
        blockWithItem(ModBlocks.BLUE_GOLD_BLOCK);
        blockWithItem(ModBlocks.ROSE_GOLD_BLOCK);
        blockWithItem(ModBlocks.STAR_BLUE_GOLD_BLOCK);
        // CRYSTAL BLOCKS
        blockWithItem(ModBlocks.MOONSTONE_CRYSTAL);
        blockWithItem(ModBlocks.IOLITE_CRYSTAL);
        blockWithItem(ModBlocks.AQUAMARINE_CRYSTAL);
        blockWithItem(ModBlocks.ROSE_QUARTZ_CRYSTAL);
        blockWithItem(ModBlocks.VERDELITE_CRYSTAL);
        blockWithItem(ModBlocks.ALEXANDRITE_CRYSTAL);
        blockWithItem(ModBlocks.RUBY_CRYSTAL);
        blockWithItem(ModBlocks.SAPPHIRE_CRYSTAL);
        blockWithItem(ModBlocks.TOURMALINE_CRYSTAL);
        blockWithItem(ModBlocks.TANZANITE_CRYSTAL);
        blockWithItem(ModBlocks.CITRINE_CRYSTAL);
        blockWithItem(ModBlocks.OPAL_CRYSTAL);
        // GEM BLOCKS
        blockWithItem(ModBlocks.MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.IOLITE_BLOCK);
        blockWithItem(ModBlocks.AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.VERDELITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.TANZANITE_BLOCK);
        blockWithItem(ModBlocks.CITRINE_BLOCK);
        blockWithItem(ModBlocks.OPAL_BLOCK);
        // GILDED GEM BLOCKS
        blockWithItem(ModBlocks.GOLDEN_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_MOONSTONE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_IOLITE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_AQUAMARINE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_VERDELITE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_RUBY_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_TOURMALINE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_TANZANITE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_CITRINE_BLOCK);
        blockWithItem(ModBlocks.GOLDEN_GILDED_OPAL_BLOCK);
        blockWithItem(ModBlocks.WHITE_GILDED_OPAL_BLOCK);
        blockWithItem(ModBlocks.BLUE_GILDED_OPAL_BLOCK);
        blockWithItem(ModBlocks.ROSE_GILDED_OPAL_BLOCK);
        blockWithItem(ModBlocks.STAR_GILDED_OPAL_BLOCK);
        blockWithItem(ModBlocks.SILVER_GILDED_OPAL_BLOCK);
        // IDOLS
        blockWithItem(ModBlocks.JAN_IDOL);


    }

    public void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
