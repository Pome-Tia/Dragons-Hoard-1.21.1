package net.pometia.dragonshoard.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.pometia.dragonshoard.DragonsHoard;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation GOLD_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_gold");
    public static final ResourceLocation GOLD_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_gold");
    public static final ResourceLocation SILVER_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_silver");
    public static final ResourceLocation SILVER_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_silver");
    public static final ResourceLocation COPPER_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_copper");
    public static final ResourceLocation COPPER_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_copper");
    public static final ResourceLocation WHITE_GOLD_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_white_gold");
    public static final ResourceLocation WHITE_GOLD_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_white_gold");
    public static final ResourceLocation BLUE_GOLD_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_blue_gold");
    public static final ResourceLocation BLUE_GOLD_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_blue_gold");
    public static final ResourceLocation ROSE_GOLD_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_rose_gold");
    public static final ResourceLocation ROSE_GOLD_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_rose_gold");
    public static final ResourceLocation STAR_GOLD_STILL_RL = ResourceLocation.parse("dragonshoard:block/source_molten_star_gold");
    public static final ResourceLocation STAR_GOLD_FLOWING_RL = ResourceLocation.parse("dragonshoard:block/flowing_molten_star_gold");
    //public static final ResourceLocation GOLD_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, DragonsHoard.MOD_ID);


    public static final Supplier<FluidType> MOLTEN_GOLD_FLUID_TYPE = registerFluidType("molten_gold_fluid", new BaseFluidType(GOLD_STILL_RL, GOLD_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_SILVER_FLUID_TYPE = registerFluidType("molten_silver_fluid", new BaseFluidType(SILVER_STILL_RL, SILVER_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_COPPER_FLUID_TYPE = registerFluidType("molten_copper_fluid", new BaseFluidType(COPPER_STILL_RL, COPPER_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_WHITE_GOLD_FLUID_TYPE = registerFluidType("molten_white_gold_fluid", new BaseFluidType(WHITE_GOLD_STILL_RL, WHITE_GOLD_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_BLUE_GOLD_FLUID_TYPE = registerFluidType("molten_blue_gold_fluid", new BaseFluidType(BLUE_GOLD_STILL_RL, BLUE_GOLD_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_ROSE_GOLD_FLUID_TYPE = registerFluidType("molten_rose_gold_fluid", new BaseFluidType(ROSE_GOLD_STILL_RL, ROSE_GOLD_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));
    public static final Supplier<FluidType> MOLTEN_STAR_GOLD_FLUID_TYPE = registerFluidType("molten_star_gold_fluid", new BaseFluidType(STAR_GOLD_STILL_RL, STAR_GOLD_FLOWING_RL,
            new Vector3f(108f / 255f, 168f / 255f, 212f / 255f),
            FluidType.Properties.create().lightLevel(15).canPushEntity(true).canDrown(true).temperature(15)));





    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

    }
