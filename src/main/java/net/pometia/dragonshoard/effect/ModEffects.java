package net.pometia.dragonshoard.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pometia.dragonshoard.DragonsHoard;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DragonsHoard.MOD_ID);


    public static final Holder<MobEffect> FLIGHT = MOB_EFFECTS.register("flight",
            () -> new JanIdolEffect(MobEffectCategory.BENEFICIAL, 0x75E5FF));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
