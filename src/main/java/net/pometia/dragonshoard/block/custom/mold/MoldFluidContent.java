package net.pometia.dragonshoard.block.custom.mold;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.fml.ModLoader;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.fluid.ModFluids;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class MoldFluidContent {
    public final Block block;
    public final Fluid fluid;
    public final int totalAmount;
    public final int maxLevel;
    public final @Nullable IntegerProperty levelProperty;
    private static final Map<Block, MoldFluidContent> BLOCK_TO_MOLD = new IdentityHashMap();
    private static final Map<Fluid, MoldFluidContent> FLUID_TO_MOLD = new IdentityHashMap();

    public int currentLevel(BlockState state) {
        if (this.fluid == Fluids.EMPTY) {
            return 0;
        } else {
            return this.levelProperty == null ? 1 : (Integer)state.getValue(this.levelProperty);
        }
    }

    private MoldFluidContent(Block block, Fluid fluid, int totalAmount, int maxLevel, @Nullable IntegerProperty levelProperty) {
        this.block = block;
        this.fluid = fluid;
        this.totalAmount = totalAmount;
        this.maxLevel = maxLevel;
        this.levelProperty = levelProperty;
    }

    public static @Nullable MoldFluidContent getForBlock(Block block) {
        return (MoldFluidContent)BLOCK_TO_MOLD.get(block);
    }

    public static @Nullable MoldFluidContent getForFluid(Fluid fluid) {
        return (MoldFluidContent)FLUID_TO_MOLD.get(fluid);
    }

    @ApiStatus.Internal
    public static void init() {
        RegisterMoldFluidContentEvent registerEvent = new RegisterMoldFluidContentEvent();
        registerEvent.register(ModBlocks.EMPTY_MOLD.get(), Fluids.EMPTY, 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_GOLD_MOLD.get(), ModFluids.SOURCE_MOLTEN_GOLD.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_SILVER_MOLD.get(), ModFluids.SOURCE_MOLTEN_SILVER.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_COPPER_MOLD.get(), ModFluids.SOURCE_MOLTEN_COPPER.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_ROSE_GOLD_MOLD.get(), ModFluids.SOURCE_MOLTEN_ROSE_GOLD.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_WHITE_GOLD_MOLD.get(), ModFluids.SOURCE_MOLTEN_WHITE_GOLD.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_BLUE_GOLD_MOLD.get(), ModFluids.SOURCE_MOLTEN_BLUE_GOLD.get(), 1000, (IntegerProperty)null);
        registerEvent.register(ModBlocks.MOLTEN_STAR_GOLD_MOLD.get(), ModFluids.SOURCE_MOLTEN_STAR_GOLD.get(), 1000, (IntegerProperty)null);
        ModLoader.postEvent(registerEvent);
    }

    static void register(Block block, Fluid fluid, int totalAmount, @Nullable IntegerProperty levelProperty) {
        if (BLOCK_TO_MOLD.get(block) != null) {
            throw new IllegalArgumentException("Duplicate cauldron registration for block %s.".formatted(block));
        } else if (FLUID_TO_MOLD.get(fluid) != null) {
            throw new IllegalArgumentException("Duplicate cauldron registration for fluid %s.".formatted(fluid));
        } else if (totalAmount <= 0) {
            throw new IllegalArgumentException("Mold total amount %d should be positive.".formatted(totalAmount));
        } else {
            MoldFluidContent data;
            if (levelProperty == null) {
                data = new MoldFluidContent(block, fluid, totalAmount, 1, (IntegerProperty)null);
            } else {
                Collection<Integer> levels = levelProperty.getPossibleValues();
                if (levels.isEmpty()) {
                    throw new IllegalArgumentException("Mold should have at least one possible level.");
                }

                int minLevel = Integer.MAX_VALUE;
                int maxLevel = 0;

                int level;
                for(Iterator var8 = levels.iterator(); var8.hasNext(); maxLevel = Math.max(maxLevel, level)) {
                    level = (Integer)var8.next();
                    minLevel = Math.min(minLevel, level);
                }

                if (minLevel != 1) {
                    throw new IllegalStateException("Minimum level should be 1, and maximum level should be >= 1.");
                }

                data = new MoldFluidContent(block, fluid, totalAmount, maxLevel, levelProperty);
            }

            BLOCK_TO_MOLD.put(block, data);
            FLUID_TO_MOLD.put(fluid, data);
        }
    }

    @ApiStatus.Internal
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        if (BLOCK_TO_MOLD.isEmpty()) {
            throw new IllegalStateException("MoldFluidContent.init() should have been called before the capability event!");
        } else {
            Iterator var1 = BLOCK_TO_MOLD.keySet().iterator();

            while(var1.hasNext()) {
                Block block = (Block)var1.next();
                event.registerBlock(Capabilities.FluidHandler.BLOCK, (level, pos, state, be, context) -> {
                    return new MoldWrapper(level, pos);
                }, new Block[]{block});
            }

        }
    }
}
