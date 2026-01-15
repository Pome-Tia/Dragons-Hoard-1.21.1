package net.pometia.dragonshoard.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Abilities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.effect.ModEffects;

@EventBusSubscriber(modid = DragonsHoard.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onMobEffectRemoval(MobEffectEvent.Expired event) {
        if (event.getEntity() instanceof ServerPlayer player && event.getEffectInstance().getEffect() == ModEffects.FLIGHT) {
            Abilities abilities = player.getAbilities();
            abilities.mayfly = !player.gameMode.isSurvival();

            if (abilities.flying && !abilities.mayfly) {
                abilities.flying = false;
                player.onUpdateAbilities();
            }
        }
    }
}
