package net.pometia.dragonshoard.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.custom.crystal.*;
//import net.pometia.dragonshoard.block.custom.forge.ForgeTankBlock;
import net.pometia.dragonshoard.block.custom.idol.*;
import net.pometia.dragonshoard.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DragonsHoard.MOD_ID);

    // MOLDS

    public static final DeferredBlock<Block> EMPTY_MOLD = registerBlock("empty_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_GOLD_MOLD = registerBlock("molten_gold_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_SILVER_MOLD = registerBlock("molten_silver_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_COPPER_MOLD = registerBlock("molten_copper_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_ROSE_GOLD_MOLD = registerBlock("molten_rose_gold_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_WHITE_GOLD_MOLD = registerBlock("molten_white_gold_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_BLUE_GOLD_MOLD = registerBlock("molten_blue_gold_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOLTEN_STAR_GOLD_MOLD = registerBlock("molten_star_gold_mold", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // BRICKS
    public static final DeferredBlock<Block> SUN_STELLAR_BRICKS = registerBlock("sun_stellar_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_STELLAR_BRICKS = registerBlock("star_stellar_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_STELLAR_BRICKS = registerBlock("moon_stellar_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SUN_UMBRAL_BRICKS = registerBlock("sun_umbral_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_UMBRAL_BRICKS = registerBlock("star_umbral_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_UMBRAL_BRICKS = registerBlock("moon_umbral_bricks",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // FORGES
    //public static final DeferredBlock<Block> STELLAR_FORGE = registerBlock("sun_stellar_forge",
            //() -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SUN_STELLAR_FORGE = registerBlock("sun_stellar_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_STELLAR_FORGE = registerBlock("star_stellar_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_STELLAR_FORGE = registerBlock("moon_stellar_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SUN_UMBRAL_FORGE = registerBlock("sun_umbral_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_UMBRAL_FORGE = registerBlock("star_umbral_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_UMBRAL_FORGE = registerBlock("moon_umbral_forge",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // CORES
    public static final DeferredBlock<Block> SUN_CORE = registerBlock("sun_core",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_CORE = registerBlock("star_core",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOON_CORE = registerBlock("moon_core",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // GEMS
    public static final DeferredBlock<Block> MOONSTONE_CRYSTAL = registerBlock("moonstone_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> IOLITE_CRYSTAL = registerBlock("iolite_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AQUAMARINE_CRYSTAL = registerBlock("aquamarine_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRYSTAL = registerBlock("rose_quartz_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VERDELITE_CRYSTAL = registerBlock("verdelite_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALEXANDRITE_CRYSTAL = registerBlock("alexandrite_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> RUBY_CRYSTAL = registerBlock("ruby_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SAPPHIRE_CRYSTAL = registerBlock("sapphire_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TOURMALINE_CRYSTAL = registerBlock("tourmaline_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TANZANITE_CRYSTAL = registerBlock("tanzanite_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CITRINE_CRYSTAL = registerBlock("citrine_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> OPAL_CRYSTAL = registerBlock("opal_crystal",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // GEM BLOCKS
    public static final DeferredBlock<Block> MOONSTONE_BLOCK = registerBlock("moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> IOLITE_BLOCK = registerBlock("iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VERDELITE_BLOCK = registerBlock("verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TOURMALINE_BLOCK = registerBlock("tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TANZANITE_BLOCK = registerBlock("tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> OPAL_BLOCK = registerBlock("opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // GILDED GEM BLOCKS
    public static final DeferredBlock<Block> GOLDEN_GILDED_MOONSTONE_BLOCK = registerBlock("golden_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_MOONSTONE_BLOCK = registerBlock("white_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_MOONSTONE_BLOCK = registerBlock("blue_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_MOONSTONE_BLOCK = registerBlock("rose_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_MOONSTONE_BLOCK = registerBlock("star_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_MOONSTONE_BLOCK = registerBlock("silver_gilded_moonstone_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_IOLITE_BLOCK = registerBlock("golden_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_IOLITE_BLOCK = registerBlock("white_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_IOLITE_BLOCK = registerBlock("blue_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_IOLITE_BLOCK = registerBlock("rose_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_IOLITE_BLOCK = registerBlock("star_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_IOLITE_BLOCK = registerBlock("silver_gilded_iolite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_AQUAMARINE_BLOCK = registerBlock("golden_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_AQUAMARINE_BLOCK = registerBlock("white_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_AQUAMARINE_BLOCK = registerBlock("blue_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_AQUAMARINE_BLOCK = registerBlock("rose_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_AQUAMARINE_BLOCK = registerBlock("star_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_AQUAMARINE_BLOCK = registerBlock("silver_gilded_aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("golden_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("white_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("blue_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("rose_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("star_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_ROSE_QUARTZ_BLOCK = registerBlock("silver_gilded_rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_VERDELITE_BLOCK = registerBlock("golden_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_VERDELITE_BLOCK = registerBlock("white_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_VERDELITE_BLOCK = registerBlock("blue_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_VERDELITE_BLOCK = registerBlock("rose_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_VERDELITE_BLOCK = registerBlock("star_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_VERDELITE_BLOCK = registerBlock("silver_gilded_verdelite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_ALEXANDRITE_BLOCK = registerBlock("golden_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_ALEXANDRITE_BLOCK = registerBlock("white_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_ALEXANDRITE_BLOCK = registerBlock("blue_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_ALEXANDRITE_BLOCK = registerBlock("rose_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_ALEXANDRITE_BLOCK = registerBlock("star_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_ALEXANDRITE_BLOCK = registerBlock("silver_gilded_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_RUBY_BLOCK = registerBlock("golden_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_RUBY_BLOCK = registerBlock("white_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_RUBY_BLOCK = registerBlock("blue_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_RUBY_BLOCK = registerBlock("rose_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_RUBY_BLOCK = registerBlock("star_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_RUBY_BLOCK = registerBlock("silver_gilded_ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_SAPPHIRE_BLOCK = registerBlock("golden_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_SAPPHIRE_BLOCK = registerBlock("white_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_SAPPHIRE_BLOCK = registerBlock("blue_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_SAPPHIRE_BLOCK = registerBlock("rose_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_SAPPHIRE_BLOCK = registerBlock("star_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_SAPPHIRE_BLOCK = registerBlock("silver_gilded_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_TOURMALINE_BLOCK = registerBlock("golden_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_TOURMALINE_BLOCK = registerBlock("white_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_TOURMALINE_BLOCK = registerBlock("blue_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_TOURMALINE_BLOCK = registerBlock("rose_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_TOURMALINE_BLOCK = registerBlock("star_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_TOURMALINE_BLOCK = registerBlock("silver_gilded_tourmaline_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_TANZANITE_BLOCK = registerBlock("golden_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_TANZANITE_BLOCK = registerBlock("white_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_TANZANITE_BLOCK = registerBlock("blue_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_TANZANITE_BLOCK = registerBlock("rose_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_TANZANITE_BLOCK = registerBlock("star_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
        public static final DeferredBlock<Block> SILVER_GILDED_TANZANITE_BLOCK = registerBlock("silver_gilded_tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_CITRINE_BLOCK = registerBlock("golden_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_CITRINE_BLOCK = registerBlock("white_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_CITRINE_BLOCK = registerBlock("blue_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_CITRINE_BLOCK = registerBlock("rose_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_CITRINE_BLOCK = registerBlock("star_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_CITRINE_BLOCK = registerBlock("silver_gilded_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> GOLDEN_GILDED_OPAL_BLOCK = registerBlock("golden_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GILDED_OPAL_BLOCK = registerBlock("white_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GILDED_OPAL_BLOCK = registerBlock("blue_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GILDED_OPAL_BLOCK = registerBlock("rose_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_GILDED_OPAL_BLOCK = registerBlock("star_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_GILDED_OPAL_BLOCK = registerBlock("silver_gilded_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // METAL
    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> WHITE_GOLD_BLOCK = registerBlock("white_gold_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLUE_GOLD_BLOCK = registerBlock("blue_gold_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STAR_BLUE_GOLD_BLOCK = registerBlock("star_blue_gold_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    // ENTITIES
    public static final DeferredBlock<Block> JAN_IDOL = registerBlock("jan_idol", () -> new JanIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> FEB_IDOL = registerBlock("feb_idol", () -> new FebIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> MAR_IDOL = registerBlock("mar_idol", () -> new MarIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> APR_IDOL = registerBlock("apr_idol", () -> new AprIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> MAY_IDOL = registerBlock("may_idol", () -> new MayIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> JUN_IDOL = registerBlock("jun_idol", () -> new JunIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> JUL_IDOL = registerBlock("jul_idol", () -> new JulIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> AUG_IDOL = registerBlock("aug_idol", () -> new AugIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> SEP_IDOL = registerBlock("sep_idol", () -> new SepIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> OCT_IDOL = registerBlock("oct_idol", () -> new OctIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> NOV_IDOL = registerBlock("nov_idol", () -> new NovIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredBlock<Block> DEC_IDOL = registerBlock("dec_idol", () -> new DecIdolBlock(BlockBehaviour.Properties.of().noOcclusion()));

    //public static final DeferredBlock<Block> FORGE_TANK = registerBlock("forge_tank", () -> new ForgeTankBlock(BlockBehaviour.Properties.of().noOcclusion()));

    // CRYSTALS
    public static final DeferredBlock<Block> ALEXANDRITE_CRYSTAL_STRUCTURE_1 = registerBlock("alexandrite_crystal_structure_1",
            () -> new CrystalStageOne(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> ALEXANDRITE_CRYSTAL_STRUCTURE_2 = registerBlock("alexandrite_crystal_structure_2",
            () -> new CrystalStageTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> ALEXANDRITE_CRYSTAL_STRUCTURE_3 = registerBlock("alexandrite_crystal_structure_3",
            () -> new CrystalStageThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> ALEXANDRITE_CRYSTAL_STRUCTURE_4 = registerBlock("alexandrite_crystal_structure_4",
            () -> new CrystalStageFour(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> IOLITE_CRYSTAL_STRUCTURE_1 = registerBlock("iolite_crystal_structure_1",
            () -> new CrystalStageOne(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> IOLITE_CRYSTAL_STRUCTURE_2 = registerBlock("iolite_crystal_structure_2",
            () -> new CrystalStageTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> IOLITE_CRYSTAL_STRUCTURE_3 = registerBlock("iolite_crystal_structure_3",
            () -> new CrystalStageThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> IOLITE_CRYSTAL_STRUCTURE_4 = registerBlock("iolite_crystal_structure_4",
            () -> new CrystalStageFour(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> MOONSTONE_CRYSTAL_STRUCTURE_1 = registerBlock("moonstone_crystal_structure_1",
            () -> new CrystalStageOne(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> MOONSTONE_CRYSTAL_STRUCTURE_2 = registerBlock("moonstone_crystal_structure_2",
            () -> new CrystalStageTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> MOONSTONE_CRYSTAL_STRUCTURE_3 = registerBlock("moonstone_crystal_structure_3",
            () -> new CrystalStageThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> MOONSTONE_CRYSTAL_STRUCTURE_4 = registerBlock("moonstone_crystal_structure_4",
            () -> new CrystalStageFour(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> TOURMALINE_CRYSTAL_STRUCTURE_1 = registerBlock("tourmaline_crystal_structure_1",
            () -> new CrystalStageOne(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> TOURMALINE_CRYSTAL_STRUCTURE_2 = registerBlock("tourmaline_crystal_structure_2",
            () -> new CrystalStageTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> TOURMALINE_CRYSTAL_STRUCTURE_3 = registerBlock("tourmaline_crystal_structure_3",
            () -> new CrystalStageThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> TOURMALINE_CRYSTAL_STRUCTURE_4 = registerBlock("tourmaline_crystal_structure_4",
            () -> new CrystalStageFour(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> VERDELITE_CRYSTAL_STRUCTURE_1 = registerBlock("verdelite_crystal_structure_1",
            () -> new CrystalStageOneVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> VERDELITE_CRYSTAL_STRUCTURE_2 = registerBlock("verdelite_crystal_structure_2",
            () -> new CrystalStageTwoVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> VERDELITE_CRYSTAL_STRUCTURE_3 = registerBlock("verdelite_crystal_structure_3",
            () -> new CrystalStageThreeVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> VERDELITE_CRYSTAL_STRUCTURE_4 = registerBlock("verdelite_crystal_structure_4",
            () -> new CrystalStageFourVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> SAPPHIRE_CRYSTAL_STRUCTURE_1 = registerBlock("sapphire_crystal_structure_1",
            () -> new CrystalStageOneVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> SAPPHIRE_CRYSTAL_STRUCTURE_2 = registerBlock("sapphire_crystal_structure_2",
            () -> new CrystalStageTwoVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> SAPPHIRE_CRYSTAL_STRUCTURE_3 = registerBlock("sapphire_crystal_structure_3",
            () -> new CrystalStageThreeVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> SAPPHIRE_CRYSTAL_STRUCTURE_4 = registerBlock("sapphire_crystal_structure_4",
            () -> new CrystalStageFourVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> RUBY_CRYSTAL_STRUCTURE_1 = registerBlock("ruby_crystal_structure_1",
            () -> new CrystalStageOneVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> RUBY_CRYSTAL_STRUCTURE_2 = registerBlock("ruby_crystal_structure_2",
            () -> new CrystalStageTwoVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> RUBY_CRYSTAL_STRUCTURE_3 = registerBlock("ruby_crystal_structure_3",
            () -> new CrystalStageThreeVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> RUBY_CRYSTAL_STRUCTURE_4 = registerBlock("ruby_crystal_structure_4",
            () -> new CrystalStageFourVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> TANZANITE_CRYSTAL_STRUCTURE_1 = registerBlock("tanzanite_crystal_structure_1",
            () -> new CrystalStageOneVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> TANZANITE_CRYSTAL_STRUCTURE_2 = registerBlock("tanzanite_crystal_structure_2",
            () -> new CrystalStageTwoVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> TANZANITE_CRYSTAL_STRUCTURE_3 = registerBlock("tanzanite_crystal_structure_3",
            () -> new CrystalStageThreeVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> TANZANITE_CRYSTAL_STRUCTURE_4 = registerBlock("tanzanite_crystal_structure_4",
            () -> new CrystalStageFourVarTwo(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> ROSE_QUARTZ_CRYSTAL_STRUCTURE_1 = registerBlock("rose_quartz_crystal_structure_1",
            () -> new CrystalStageOneVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRYSTAL_STRUCTURE_2 = registerBlock("rose_quartz_crystal_structure_2",
            () -> new CrystalStageTwoVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRYSTAL_STRUCTURE_3 = registerBlock("rose_quartz_crystal_structure_3",
            () -> new CrystalStageThreeVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> ROSE_QUARTZ_CRYSTAL_STRUCTURE_4 = registerBlock("rose_quartz_crystal_structure_4",
            () -> new CrystalStageFourVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> OPAL_CRYSTAL_STRUCTURE_1 = registerBlock("opal_crystal_structure_1",
            () -> new CrystalStageOneVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> OPAL_CRYSTAL_STRUCTURE_2 = registerBlock("opal_crystal_structure_2",
            () -> new CrystalStageTwoVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> OPAL_CRYSTAL_STRUCTURE_3 = registerBlock("opal_crystal_structure_3",
            () -> new CrystalStageThreeVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> OPAL_CRYSTAL_STRUCTURE_4 = registerBlock("opal_crystal_structure_4",
            () -> new CrystalStageFourVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> CITRINE_CRYSTAL_STRUCTURE_1 = registerBlock("citrine_crystal_structure_1",
            () -> new CrystalStageOneVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> CITRINE_CRYSTAL_STRUCTURE_2 = registerBlock("citrine_crystal_structure_2",
            () -> new CrystalStageTwoVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> CITRINE_CRYSTAL_STRUCTURE_3 = registerBlock("citrine_crystal_structure_3",
            () -> new CrystalStageThreeVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> CITRINE_CRYSTAL_STRUCTURE_4 = registerBlock("citrine_crystal_structure_4",
            () -> new CrystalStageFourVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    public static final DeferredBlock<Block> AQUAMARINE_CRYSTAL_STRUCTURE_1 = registerBlock("aquamarine_crystal_structure_1",
            () -> new CrystalStageOneVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 4)));
    public static final DeferredBlock<Block> AQUAMARINE_CRYSTAL_STRUCTURE_2 = registerBlock("aquamarine_crystal_structure_2",
            () -> new CrystalStageTwoVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 8)));
    public static final DeferredBlock<Block> AQUAMARINE_CRYSTAL_STRUCTURE_3 = registerBlock("aquamarine_crystal_structure_3",
            () -> new CrystalStageThreeVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 12)));
    public static final DeferredBlock<Block> AQUAMARINE_CRYSTAL_STRUCTURE_4 = registerBlock("aquamarine_crystal_structure_4",
            () -> new CrystalStageFourVarThree(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 15)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
