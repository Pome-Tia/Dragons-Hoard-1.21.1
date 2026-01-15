package net.pometia.dragonshoard.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.item.ModItems;

import java.util.function.Supplier;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, DragonsHoard.MOD_ID);

    // GOLD
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_GOLD = FLUIDS.register("source_molten_gold", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_GOLD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_GOLD = FLUIDS.register("flowing_molten_gold", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_GOLD_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_GOLD_BLOCK = ModBlocks.BLOCKS.register("molten_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_GOLD_BUCKET = ModItems.ITEMS.registerItem("molten_gold_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_GOLD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_GOLD_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_GOLD_FLUID_TYPE, SOURCE_MOLTEN_GOLD, FLOWING_MOLTEN_GOLD)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_GOLD_BLOCK).bucket(ModFluids.MOLTEN_GOLD_BUCKET);

    // SILVER
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_SILVER = FLUIDS.register("source_molten_silver", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_SILVER_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_SILVER = FLUIDS.register("flowing_molten_silver", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_SILVER_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_SILVER_BLOCK = ModBlocks.BLOCKS.register("molten_silver_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_SILVER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_SILVER_BUCKET = ModItems.ITEMS.registerItem("molten_silver_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_SILVER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_SILVER_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_SILVER_FLUID_TYPE, SOURCE_MOLTEN_SILVER, FLOWING_MOLTEN_SILVER)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_SILVER_BLOCK).bucket(ModFluids.MOLTEN_SILVER_BUCKET);

    // COPPER
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_COPPER = FLUIDS.register("source_molten_copper", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_COPPER_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_COPPER = FLUIDS.register("flowing_molten_copper", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_COPPER_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_COPPER_BLOCK = ModBlocks.BLOCKS.register("molten_copper_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_COPPER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_COPPER_BUCKET = ModItems.ITEMS.registerItem("molten_copper_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_COPPER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_COPPER_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_COPPER_FLUID_TYPE, SOURCE_MOLTEN_COPPER, FLOWING_MOLTEN_COPPER)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_COPPER_BLOCK).bucket(ModFluids.MOLTEN_COPPER_BUCKET);

    // WHITE GOLD
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_WHITE_GOLD = FLUIDS.register("source_molten_white_gold", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_WHITE_GOLD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_WHITE_GOLD = FLUIDS.register("flowing_molten_white_gold", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_WHITE_GOLD_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_WHITE_GOLD_BLOCK = ModBlocks.BLOCKS.register("molten_white_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_WHITE_GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_WHITE_GOLD_BUCKET = ModItems.ITEMS.registerItem("molten_white_gold_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_WHITE_GOLD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_WHITE_GOLD_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_WHITE_GOLD_FLUID_TYPE, SOURCE_MOLTEN_WHITE_GOLD, FLOWING_MOLTEN_WHITE_GOLD)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_WHITE_GOLD_BLOCK).bucket(ModFluids.MOLTEN_WHITE_GOLD_BUCKET);

    // BLUE GOLD
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_BLUE_GOLD = FLUIDS.register("source_molten_blue_gold", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_BLUE_GOLD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_BLUE_GOLD = FLUIDS.register("flowing_molten_blue_gold", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_BLUE_GOLD_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_BLUE_GOLD_BLOCK = ModBlocks.BLOCKS.register("molten_blue_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_BLUE_GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_BLUE_GOLD_BUCKET = ModItems.ITEMS.registerItem("molten_blue_gold_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_BLUE_GOLD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_BLUE_GOLD_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_BLUE_GOLD_FLUID_TYPE, SOURCE_MOLTEN_BLUE_GOLD, FLOWING_MOLTEN_BLUE_GOLD)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_BLUE_GOLD_BLOCK).bucket(ModFluids.MOLTEN_BLUE_GOLD_BUCKET);

    // ROSE GOLD
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_ROSE_GOLD = FLUIDS.register("source_molten_rose_gold", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_ROSE_GOLD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_ROSE_GOLD = FLUIDS.register("flowing_molten_rose_gold", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_ROSE_GOLD_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_ROSE_GOLD_BLOCK = ModBlocks.BLOCKS.register("molten_rose_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_ROSE_GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_ROSE_GOLD_BUCKET = ModItems.ITEMS.registerItem("molten_rose_gold_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_ROSE_GOLD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_ROSE_GOLD_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_ROSE_GOLD_FLUID_TYPE, SOURCE_MOLTEN_ROSE_GOLD, FLOWING_MOLTEN_ROSE_GOLD)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_ROSE_GOLD_BLOCK).bucket(ModFluids.MOLTEN_ROSE_GOLD_BUCKET);

    // STAR GOLD
    public static final Supplier<FlowingFluid> SOURCE_MOLTEN_STAR_GOLD = FLUIDS.register("source_molten_star_gold", () -> new MoltenFluidTypes.Source(ModFluids.MOLTEN_STAR_GOLD_PROPERTIES));
    public static final Supplier<FlowingFluid> FLOWING_MOLTEN_STAR_GOLD = FLUIDS.register("flowing_molten_star_gold", () -> new MoltenFluidTypes.Flowing(ModFluids.MOLTEN_STAR_GOLD_PROPERTIES));
    //block
    public static final DeferredBlock<LiquidBlock> MOLTEN_STAR_GOLD_BLOCK = ModBlocks.BLOCKS.register("molten_star_gold_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_STAR_GOLD.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));
    //bucket
    public static final DeferredItem<Item> MOLTEN_STAR_GOLD_BUCKET = ModItems.ITEMS.registerItem("molten_star_gold_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_MOLTEN_STAR_GOLD.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    //properties
    public static final MoltenFluidTypes.Properties MOLTEN_STAR_GOLD_PROPERTIES = new MoltenFluidTypes.Properties(
            ModFluidTypes.MOLTEN_STAR_GOLD_FLUID_TYPE, SOURCE_MOLTEN_STAR_GOLD, FLOWING_MOLTEN_STAR_GOLD)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModFluids.MOLTEN_STAR_GOLD_BLOCK).bucket(ModFluids.MOLTEN_STAR_GOLD_BUCKET);



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
