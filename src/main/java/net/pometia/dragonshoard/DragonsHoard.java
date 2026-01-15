package net.pometia.dragonshoard;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import net.pometia.dragonshoard.effect.ModEffects;
import net.pometia.dragonshoard.fluid.BaseFluidType;
import net.pometia.dragonshoard.fluid.ModFluidTypes;
import net.pometia.dragonshoard.fluid.ModFluids;
import net.pometia.dragonshoard.item.ModCreativeModeTabs;
import net.pometia.dragonshoard.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DragonsHoard.MOD_ID)
public class DragonsHoard {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "dragonshoard";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public DragonsHoard(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            // GEMS (ITEMS)
            event.accept(ModItems.MOONSTONE_GEM);
            event.accept(ModItems.IOLITE_GEM);
            event.accept(ModItems.AQUAMARINE_GEM);
            event.accept(ModItems.ROSE_QUARTZ_GEM);
            event.accept(ModItems.VERDELITE_GEM);
            event.accept(ModItems.ALEXANDRITE_GEM);
            event.accept(ModItems.RUBY_GEM);
            event.accept(ModItems.SAPPHIRE_GEM);
            event.accept(ModItems.TOURMALINE_GEM);
            event.accept(ModItems.TANZANITE_GEM);
            event.accept(ModItems.CITRINE_GEM);
            event.accept(ModItems.OPAL_GEM);
            // INGOTS
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModItems.WHITE_GOLD_INGOT);
            event.accept(ModItems.BLUE_GOLD_INGOT);
            event.accept(ModItems.ROSE_GOLD_INGOT);
            event.accept(ModItems.STAR_BLUE_GOLD_INGOT);


            // FLOWERS
//            event.accept(ModItems.SNOWDROP);
//            event.accept(ModItems.VIOLETS);
//            event.accept(ModItems.DAFFODIL);
//            event.accept(ModItems.LARKSPUR);
//            event.accept(ModItems.BLUE_ROSE);
//            event.accept(ModItems.MARIGOLD);
//            event.accept(ModItems.MORNING_GLORY);
//            event.accept(ModItems.NARCISSUS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientExtensions(RegisterClientExtensionsEvent event) {
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_GOLD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_GOLD_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_SILVER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_SILVER_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_WHITE_GOLD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_WHITE_GOLD_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_BLUE_GOLD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_BLUE_GOLD_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_ROSE_GOLD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_ROSE_GOLD_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_STAR_GOLD_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_STAR_GOLD_FLUID_TYPE.get());
            event.registerFluidType(((BaseFluidType) ModFluidTypes.MOLTEN_COPPER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                    ModFluidTypes.MOLTEN_COPPER_FLUID_TYPE.get());
        }
    }
}
