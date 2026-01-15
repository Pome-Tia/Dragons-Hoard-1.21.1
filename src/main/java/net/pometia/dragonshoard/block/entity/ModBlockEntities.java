package net.pometia.dragonshoard.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.block.ModBlocks;
//import net.pometia.dragonshoard.block.entity.custom.forge.ForgeTankBlockEntity;
import net.pometia.dragonshoard.block.entity.custom.idol.JanIdolBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntities {


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DragonsHoard.MOD_ID);


    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> JAN_IDOL_BE = BLOCK_ENTITIES.register("jan_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.JAN_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> FEB_IDOL_BE = BLOCK_ENTITIES.register("feb_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.FEB_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> MAR_IDOL_BE = BLOCK_ENTITIES.register("mar_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.MAR_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> APR_IDOL_BE = BLOCK_ENTITIES.register("apr_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.APR_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> MAY_IDOL_BE = BLOCK_ENTITIES.register("may_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.MAY_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> JUN_IDOL_BE = BLOCK_ENTITIES.register("jun_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.JUN_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> JUL_IDOL_BE = BLOCK_ENTITIES.register("jul_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.JUL_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> AUG_IDOL_BE = BLOCK_ENTITIES.register("aug_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.AUG_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> SEP_IDOL_BE = BLOCK_ENTITIES.register("sep_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.SEP_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> OCT_IDOL_BE = BLOCK_ENTITIES.register("oct_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.OCT_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> NOV_IDOL_BE = BLOCK_ENTITIES.register("nov_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.NOV_IDOL.get()).build(null));
    public static final Supplier<BlockEntityType<JanIdolBlockEntity>> DEC_IDOL_BE = BLOCK_ENTITIES.register("dec_idol_be", () -> BlockEntityType.Builder.of(JanIdolBlockEntity::new, ModBlocks.DEC_IDOL.get()).build(null));

    //public static final Supplier<BlockEntityType<ForgeTankBlockEntity>> FORGE_TANK_BE = BLOCK_ENTITIES.register("forge_tank_be", () -> BlockEntityType.Builder.of(ForgeTankBlockEntity::new, ModBlocks.FORGE_TANK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
