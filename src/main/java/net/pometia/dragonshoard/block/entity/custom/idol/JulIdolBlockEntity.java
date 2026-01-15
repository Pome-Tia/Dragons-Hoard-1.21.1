package net.pometia.dragonshoard.block.entity.custom.idol;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import net.pometia.dragonshoard.effect.ModEffects;
import net.pometia.dragonshoard.util.ModTags;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class JulIdolBlockEntity extends BlockEntity {

    public final List<BlockPos> activatingBlocks = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocks = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal1 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal2 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal3 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal4 = Lists.newArrayList();
    public final List<BlockPos> enhancingBlocksVal5 = Lists.newArrayList();

    public int tickCount;
    private float activeRotation;
    private boolean isActive;
    private boolean isHunting;
    @Nullable
    private LivingEntity destroyTarget;
    @Nullable
    private UUID destroyTargetUUID;
    private long nextAmbientSoundActivation;

    public JulIdolBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.JUL_IDOL_BE.get(), pos, blockState);
    };

    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.hasUUID("Target")) {
            this.destroyTargetUUID = tag.getUUID("Target");
        } else {
            this.destroyTargetUUID = null;
        }

    }

    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (this.destroyTarget != null) {
            tag.putUUID("Target", this.destroyTarget.getUUID());
        }

    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }


    public static void clientTick (Level level, BlockPos pos, BlockState state, JulIdolBlockEntity blockEntity){
        //System.out.println("Client is ticking.");
        ++blockEntity.tickCount;
        long i = level.getGameTime();
        List<BlockPos> list = blockEntity.activatingBlocks;
        List<BlockPos> list2 = blockEntity.enhancingBlocks;
        List<BlockPos> val1 = blockEntity.enhancingBlocksVal1;
        List<BlockPos> val2 = blockEntity.enhancingBlocksVal2;
        List<BlockPos> val3 = blockEntity.enhancingBlocksVal3;
        List<BlockPos> val4 = blockEntity.enhancingBlocksVal4;
        List<BlockPos> val5 = blockEntity.enhancingBlocksVal5;
        if (i % 40L == 0L) {
            //blockEntity.isActive = updateActivatingBlocks(level, pos, list);
            blockEntity.isActive = updateEnhancingBlocks(level, pos, list2, val1, val2, val3, val4, val5);
            updateHunting(blockEntity, list);
        }

        updateClientTarget(level, pos, blockEntity);
        spawnParticles(level, pos, list2, blockEntity.destroyTarget, blockEntity.tickCount);
        if (blockEntity.isActive()) {
            blockEntity.tickCount++;
        }

    }

    public static void serverTick (Level level, BlockPos pos, BlockState state, JulIdolBlockEntity blockEntity){
        //System.out.println("Server is ticking.");
        ++blockEntity.tickCount;
        long i = level.getGameTime();
        List<BlockPos> list = blockEntity.activatingBlocks;
        List<BlockPos> list2 = blockEntity.enhancingBlocks;
        List<BlockPos> val1 = blockEntity.enhancingBlocksVal1;
        List<BlockPos> val2 = blockEntity.enhancingBlocksVal2;
        List<BlockPos> val3 = blockEntity.enhancingBlocksVal3;
        List<BlockPos> val4 = blockEntity.enhancingBlocksVal4;
        List<BlockPos> val5 = blockEntity.enhancingBlocksVal5;
        if (i % 40L == 0L) {
            //boolean bl = updateActivatingBlocks(level, pos, list);
            boolean bl2 = updateEnhancingBlocks(level, pos, list2, val1, val2, val3, val4, val5);
            if (bl2 != blockEntity.isActive) {
                SoundEvent soundevent = bl2 ? SoundEvents.CONDUIT_ACTIVATE : SoundEvents.CONDUIT_DEACTIVATE;
                level.playSound((Player) null, pos, soundevent, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            blockEntity.isActive = bl2;
            updateHunting(blockEntity, list);
            if (bl2) {
                applyEffects(level, pos, val1, val2, val3, val4, val5);
                updateDestroyTarget(level, pos, state, list2, blockEntity);
            }
        }

        if (blockEntity.isActive()) {
            if (i % 80L == 0L) {
                level.playSound((Player) null, pos, SoundEvents.CONDUIT_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            if (i > blockEntity.nextAmbientSoundActivation) {
                blockEntity.nextAmbientSoundActivation = i + 60L + (long) level.getRandom().nextInt(40);
                level.playSound((Player) null, pos, SoundEvents.CONDUIT_AMBIENT_SHORT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }

    }


    private static void applyEffects (Level level, BlockPos pos, List<BlockPos> enhancingBlocksVal1, List<BlockPos> enhancingBlocksVal2, List<BlockPos> enhancingBlocksVal3, List<BlockPos> enhancingBlocksVal4, List<BlockPos> enhancingBlocksVal5){
        int i = offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5);
        int j = 10 + i / 16;
        int k = pos.getX();
        int l = pos.getY();
        int m = pos.getZ();
        AABB aabb = new AABB((double) k, (double) l, (double) m, (double) (k + 1), (double) (l + 1), (double) (m + 1))
                .inflate((double) j)
                .expandTowards(0.0, (double) level.getHeight(), 0.0);
        List<Player> list = level.getEntitiesOfClass(Player.class, aabb);
        if (!list.isEmpty()) {
            for (Player playerEntity : list) {
                if (pos.closerThan(playerEntity.blockPosition(), (double) j)) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                }
                if (pos.closerThan(playerEntity.blockPosition(), (double) j) && i >= 256) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 260, 0, true, true));
                }
                if (pos.closerThan(playerEntity.blockPosition(), (double) j) && i >= 512) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 260, 1, true, true));
                }
                if (pos.closerThan(playerEntity.blockPosition(), (double) j) && i >= 768) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 260, 2, true, true));
                }
                if (pos.closerThan(playerEntity.blockPosition(), (double) j) && i >= 1024) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 0, true, true));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 260, 2, true, true));
                    playerEntity.addEffect(new MobEffectInstance(ModEffects.FLIGHT, 260, 0, true, true));
                }

            }
        }
    }

    private static void spawnParticles (Level level, BlockPos pos, List < BlockPos > enhancingBlocks, @Nullable Entity
            entity,int ticks){
        RandomSource random = level.random;
        double d = (double) (Math.sin((float) (ticks + 35) * 0.1F) / 2.0F + 0.5F);
        d = (d * d + d) * 0.3F;
        Vec3 vec3 = new Vec3((double) pos.getX() + 0.5, (double) pos.getY() + 1.5 + d, (double) pos.getZ() + 0.5);

        for (BlockPos blockPos : enhancingBlocks) {
            if (random.nextInt(200) == 0) {
                BlockPos blockPos2 = blockPos.subtract(pos);
                float f = -0.5F + random.nextFloat() + (float) blockPos2.getX();
                float g = -2.0F + random.nextFloat() + (float) blockPos2.getY();
                float h = -0.5F + random.nextFloat() + (float) blockPos2.getZ();
                level.addParticle(ParticleTypes.ENCHANT, vec3.x, vec3.y, vec3.z, (double) f, (double) g, (double) h);
            }
        }

        if (entity != null) {
            Vec3 vec3d2 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
            float i = (-0.5F + random.nextFloat()) * (3.0F + entity.getBbWidth());
            float j = -1.0F + random.nextFloat() * entity.getBbHeight();
            float f = (-0.5F + random.nextFloat()) * (3.0F + entity.getBbWidth());
            Vec3 vec3d3 = new Vec3((double) i, (double) j, (double) f);
            level.addParticle(ParticleTypes.ENCHANT, vec3d2.x, vec3d2.y, vec3d2.z, vec3d3.x, vec3d3.y, vec3d3.z);
        }
    }

    public boolean isActive () {
        return this.isActive;
    }

    public boolean isHunting () {
        return this.isHunting;
    }

    private void setHunting ( boolean isHunting){
        this.isHunting = isHunting;
    }

    private static void updateHunting (JulIdolBlockEntity blockEntity, List < BlockPos > enhancingBlocks){
        blockEntity.setHunting(enhancingBlocks.size() >= 64);
    }

    private static void updateDestroyTarget (Level level, BlockPos pos, BlockState
            state, List < BlockPos > enhancingBlocks, JulIdolBlockEntity blockEntity){
        LivingEntity livingentity = blockEntity.destroyTarget;
        int i = enhancingBlocks.size();
        if (i < 64) {
            blockEntity.destroyTarget = null;
        } else if (blockEntity.destroyTarget == null && blockEntity.destroyTargetUUID != null) {
            blockEntity.destroyTarget = findDestroyTarget(level, pos, blockEntity.destroyTargetUUID);
            blockEntity.destroyTargetUUID = null;
        } else if (blockEntity.destroyTarget == null) {
            List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, getDestroyRangeAABB(pos), (p_350210_) -> {
                return p_350210_ instanceof Enemy;
            });
            if (!list.isEmpty()) {
                blockEntity.destroyTarget = (LivingEntity) list.get(level.random.nextInt(list.size()));
            }
        } else if (!blockEntity.destroyTarget.isAlive() || !pos.closerThan(blockEntity.destroyTarget.blockPosition(), 8.0)) {
            blockEntity.destroyTarget = null;
        }

        if (blockEntity.destroyTarget != null) {
            level.playSound((Player) null, blockEntity.destroyTarget.getX(), blockEntity.destroyTarget.getY(), blockEntity.destroyTarget.getZ(), SoundEvents.CONDUIT_ATTACK_TARGET, SoundSource.BLOCKS, 1.0F, 1.0F);
            blockEntity.destroyTarget.hurt(level.damageSources().magic(), 4.0F);
        }

        if (livingentity != blockEntity.destroyTarget) {
            level.sendBlockUpdated(pos, state, state, 2);
        }

    }

    private static void updateClientTarget (Level level, BlockPos pos, JulIdolBlockEntity blockEntity){
        if (blockEntity.destroyTargetUUID == null) {
            blockEntity.destroyTarget = null;
        } else if (blockEntity.destroyTarget == null || !blockEntity.destroyTarget.getUUID().equals(blockEntity.destroyTargetUUID)) {
            blockEntity.destroyTarget = findDestroyTarget(level, pos, blockEntity.destroyTargetUUID);
            if (blockEntity.destroyTarget == null) {
                blockEntity.destroyTargetUUID = null;
            }
        }

    }

    private static AABB getDestroyRangeAABB (BlockPos pos){
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        return (new AABB((double) i, (double) j, (double) k, (double) (i + 1), (double) (j + 1), (double) (k + 1))).inflate(8.0);
    }

    @Nullable
    private static LivingEntity findDestroyTarget (Level level, BlockPos pos, UUID targetId){
        List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, getDestroyRangeAABB(pos), (p_352880_) -> {
            return p_352880_.getUUID().equals(targetId);
        });
        return list.size() == 1 ? (LivingEntity) list.get(0) : null;
    }

    private static boolean updateActivatingBlocks (Level level, BlockPos pos, List<BlockPos> activatingBlocks){
        System.out.println(activatingBlocks.size());
        activatingBlocks.clear();

        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                for (int kx = -4; kx <= 4; kx++) {
                    int l = Math.abs(i);
                    int m = Math.abs(j);
                    int n = Math.abs(kx);
                    BlockPos blockPos2 = pos.offset(i, j, kx);
                    BlockState blockState = level.getBlockState(blockPos2);

                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_1)) {
                        activatingBlocks.add(blockPos2);
                    }
                }
            }
        }


        return activatingBlocks.size() >= 10;
    }

    public static boolean updateEnhancingBlocks (Level level, BlockPos
            pos, List < BlockPos > enhancingBlocks, List < BlockPos > enhancingBlocksVal1, List < BlockPos > enhancingBlocksVal2, List < BlockPos > enhancingBlocksVal3, List < BlockPos > enhancingBlocksVal4, List < BlockPos > enhancingBlocksVal5)
    {
        //System.out.println(enhancingBlocks.size());
        enhancingBlocks.clear();
        enhancingBlocksVal1.clear();
        enhancingBlocksVal2.clear();
        enhancingBlocksVal3.clear();
        enhancingBlocksVal4.clear();
        enhancingBlocksVal5.clear();


        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                for (int kx = -4; kx <= 4; kx++) {
                    int l = Math.abs(i);
                    int m = Math.abs(j);
                    int n = Math.abs(kx);
                    BlockPos blockPos2 = pos.offset(i, j, kx);
                    BlockState blockState = level.getBlockState(blockPos2);

                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_1)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal1.add(blockPos2);
                    }

                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_2)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal2.add(blockPos2);
                    }

                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_3)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal3.add(blockPos2);
                    }
                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_4)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal4.add(blockPos2);
                    }
                    if (blockState.is(ModTags.Blocks.JUL_FAVORED_BLOCKS_VALUE_5)) {
                        enhancingBlocks.add(blockPos2);
                        enhancingBlocksVal5.add(blockPos2);
                    }

                }
            }
        }

        System.out.println(offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5));
        return offeringsTotal(enhancingBlocksVal1, enhancingBlocksVal2, enhancingBlocksVal3, enhancingBlocksVal4, enhancingBlocksVal5) >= 10;
    }

    public static int offeringsTotal
            (List < BlockPos > enhancingBlocksVal1, List < BlockPos > enhancingBlocksVal2, List < BlockPos > enhancingBlocksVal3, List < BlockPos > enhancingBlocksVal4, List < BlockPos > enhancingBlocksVal5)
    {

        int val1 = Math.abs(enhancingBlocksVal1.size());
        int val2 = Math.abs(enhancingBlocksVal2.size() * 4);
        int val3 = Math.abs(enhancingBlocksVal3.size() * 8);
        int val4 = Math.abs(enhancingBlocksVal4.size() * 16);
        int val5 = Math.abs(enhancingBlocksVal5.size() * 32);

        return val1 + val2 + val3 + val4 + val5;

    }

    public RenderShape getRenderShape (BlockState state){
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

}

