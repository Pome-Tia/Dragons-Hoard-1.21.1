package net.pometia.dragonshoard.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.*;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class MoltenFluidTypes extends FlowingFluid {
    private final Supplier<? extends FluidType> fluidType;
    private final Supplier<? extends Fluid> flowing;
    private final Supplier<? extends Fluid> still;
    private final @org.jetbrains.annotations.Nullable Supplier<? extends Item> bucket;
    private final @org.jetbrains.annotations.Nullable Supplier<? extends LiquidBlock> block;
    private final int slopeFindDistance;
    private final int levelDecreasePerBlock;
    private final float explosionResistance;
    //private int tickRate;

    protected MoltenFluidTypes(MoltenFluidTypes.Properties properties) {
        this.fluidType = properties.fluidType;
        this.flowing = properties.flowing;
        this.still = properties.still;
        this.bucket = properties.bucket;
        this.block = properties.block;
        this.slopeFindDistance = properties.slopeFindDistance;
        this.levelDecreasePerBlock = properties.levelDecreasePerBlock;
        this.explosionResistance = properties.explosionResistance;
        //this.tickRate = properties.tickRate;
    }

    public FluidType getFluidType() {
        return (FluidType)this.fluidType.get();
    }

    public Fluid getFlowing() {
        return (Fluid)this.flowing.get();
    }

    public Fluid getSource() {
        return (Fluid)this.still.get();
    }

    protected boolean canConvertToSource(Level level) {
        return false;
    }

    public boolean canConvertToSource(FluidState state, Level level, BlockPos pos) {
        return this.getFluidType().canConvertToSource(state, level, pos);
    }

    protected void beforeDestroyingBlock(LevelAccessor worldIn, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? worldIn.getBlockEntity(pos) : null;
        Block.dropResources(state, worldIn, pos, blockEntity);
    }

    protected int getSlopeFindDistance(LevelReader worldIn) {
        return this.slopeFindDistance;
    }

    protected int getDropOff(LevelReader worldIn) {
        return this.levelDecreasePerBlock;
    }

    public Item getBucket() {
        return this.bucket != null ? (Item)this.bucket.get() : Items.AIR;
    }

    protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluidIn, Direction direction) {
        return direction == Direction.DOWN && !this.isSame(fluidIn);
    }

    public int getTickDelay(LevelReader level) {
        return 20;
    }

    protected float getExplosionResistance() {
        return this.explosionResistance;
    }

    protected BlockState createLegacyBlock(FluidState state) {
        return this.block != null ? (BlockState)((LiquidBlock)this.block.get()).defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state)) : Blocks.AIR.defaultBlockState();
    }

    public boolean isSame(Fluid fluidIn) {
        return fluidIn == this.still.get() || fluidIn == this.flowing.get();
    }

    public Optional<SoundEvent> getPickupSound() {
        return Optional.ofNullable(this.getFluidType().getSound(SoundActions.BUCKET_FILL));
    }

    public static class Properties {
        private Supplier<? extends FluidType> fluidType;
        private Supplier<? extends Fluid> still;
        private Supplier<? extends Fluid> flowing;
        private Supplier<? extends Item> bucket;
        private Supplier<? extends LiquidBlock> block;
        private int slopeFindDistance = 2;
        private int levelDecreasePerBlock = 1;
        private float explosionResistance = 1.0F;
        private int tickRate = 5;

        public Properties(Supplier<? extends FluidType> fluidType, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing) {
            this.fluidType = fluidType;
            this.still = still;
            this.flowing = flowing;
        }

        public MoltenFluidTypes.Properties bucket(Supplier<? extends Item> bucket) {
            this.bucket = bucket;
            return this;
        }

        public MoltenFluidTypes.Properties block(Supplier<? extends LiquidBlock> block) {
            this.block = block;
            return this;
        }

        public MoltenFluidTypes.Properties slopeFindDistance(int slopeFindDistance) {
            this.slopeFindDistance = slopeFindDistance;
            return this;
        }

        public MoltenFluidTypes.Properties levelDecreasePerBlock(int levelDecreasePerBlock) {
            this.levelDecreasePerBlock = levelDecreasePerBlock;
            return this;
        }

        public MoltenFluidTypes.Properties explosionResistance(float explosionResistance) {
            this.explosionResistance = explosionResistance;
            return this;
        }

        public MoltenFluidTypes.Properties tickRate(int tickRate) {
            this.tickRate = tickRate;
            return this;
        }
    }

    public static class Source extends MoltenFluidTypes {
        public Source(Properties properties) {
            super(properties);
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends MoltenFluidTypes {
        public Flowing(Properties properties) {
            super(properties);
            this.registerDefaultState((FluidState)((FluidState)this.getStateDefinition().any()).setValue(LEVEL, 7));
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(new Property[]{LEVEL});
        }

        public int getAmount(FluidState state) {
            return (Integer)state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static final float MIN_LEVEL_CUTOFF = 0.44444445F;

    //    public Fluid getFlowing() {
//        return ModFluids.FLOWING_MOLTEN_GOLD.get();
//    }
//
//    public Fluid getSource() {
//        return ModFluids.SOURCE_MOLTEN_GOLD.get();
//    }
//
//    public Item getBucket() {
//        return ModFluids.MOLTEN_GOLD_BUCKET.get();
//    }

    public void animateTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        BlockPos blockpos = pos.above();
        if (level.getBlockState(blockpos).isAir() && !level.getBlockState(blockpos).isSolidRender(level, blockpos)) {
            if (random.nextInt(100) == 0) {
                double d0 = (double)pos.getX() + random.nextDouble();
                double d1 = (double)pos.getY() + 1.0;
                double d2 = (double)pos.getZ() + random.nextDouble();
                level.addParticle(ParticleTypes.LAVA, d0, d1, d2, 0.0, 0.0, 0.0);
                level.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }

            if (random.nextInt(200) == 0) {
                level.playLocalSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }

    }

    public void randomTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = pos;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.offset(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!level.isLoaded(blockpos)) {
                        return;
                    }

                    BlockState blockstate = level.getBlockState(blockpos);
                    if (blockstate.isAir()) {
                        if (this.hasFlammableNeighbours(level, blockpos)) {
                            level.setBlockAndUpdate(blockpos, EventHooks.fireFluidPlaceBlockEvent(level, blockpos, pos, BaseFireBlock.getState(level, blockpos)));
                            return;
                        }
                    } else if (blockstate.blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!level.isLoaded(blockpos1)) {
                        return;
                    }

                    if (level.isEmptyBlock(blockpos1.above()) && this.isFlammable(level, blockpos1, Direction.UP)) {
                        level.setBlockAndUpdate(blockpos1.above(), EventHooks.fireFluidPlaceBlockEvent(level, blockpos1.above(), pos, BaseFireBlock.getState(level, blockpos1)));
                    }
                }
            }
        }

    }

    private boolean hasFlammableNeighbours(LevelReader level, BlockPos pos) {
        Direction[] var3 = Direction.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Direction direction = var3[var5];
            if (this.isFlammable(level, pos.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }

    /** @deprecated */
    @Deprecated
    private boolean isFlammable(LevelReader level, BlockPos pos) {
        return pos.getY() >= level.getMinBuildHeight() && pos.getY() < level.getMaxBuildHeight() && !level.hasChunkAt(pos) ? false : level.getBlockState(pos).ignitedByLava();
    }

    private boolean isFlammable(LevelReader p_level, BlockPos p_pos, Direction face) {
        if (p_pos.getY() >= p_level.getMinBuildHeight() && p_pos.getY() < p_level.getMaxBuildHeight() && !p_level.hasChunkAt(p_pos)) {
            return false;
        } else {
            BlockState state = p_level.getBlockState(p_pos);
            return state.ignitedByLava(p_level, p_pos, face);
        }
    }

    @Nullable
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

//    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
//        this.fizz(level, pos);
//    }
//
//    public int getSlopeFindDistance(LevelReader level) {
//        return level.dimensionType().ultraWarm() ? 4 : 2;
//    }
//
//    public BlockState createLegacyBlock(FluidState state) {
//        return (BlockState) Blocks.LAVA.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
//    }
//
//    public boolean isSame(Fluid fluid) {
//        return fluid == ModFluids.SOURCE_MOLTEN_GOLD || fluid == ModFluids.FLOWING_MOLTEN_GOLD;
//    }
//
//    public int getDropOff(LevelReader level) {
//        return level.dimensionType().ultraWarm() ? 1 : 2;
//    }
//
//    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockReader, BlockPos pos, Fluid fluid, Direction direction) {
//        return fluidState.getHeight(blockReader, pos) >= 0.44444445F && fluid.is(FluidTags.WATER);
//    }
//
//    public int getTickDelay(LevelReader level) {
//        return level.dimensionType().ultraWarm() ? 10 : 30;
//    }

    public int getSpreadDelay(Level level, BlockPos pos, FluidState currentState, FluidState newState) {
        int i = this.getTickDelay(level);
        if (!currentState.isEmpty() && !newState.isEmpty() && !(Boolean)currentState.getValue(FALLING) && !(Boolean)newState.getValue(FALLING) && newState.getHeight(level, pos) > currentState.getHeight(level, pos) && level.getRandom().nextInt(4) != 0) {
            i *= 4;
        }

        return i;
    }

    private void fizz(LevelAccessor level, BlockPos pos) {
        level.levelEvent(1501, pos, 0);
    }

//    protected boolean canConvertToSource(Level level) {
//        return level.getGameRules().getBoolean(GameRules.RULE_LAVA_SOURCE_CONVERSION);
//    }

    protected void spreadTo(LevelAccessor level, BlockPos pos, BlockState blockState, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidstate = level.getFluidState(pos);
            if (this.is(FluidTags.LAVA) && fluidstate.is(FluidTags.WATER)) {
                if (blockState.getBlock() instanceof LiquidBlock) {
                    level.setBlock(pos, EventHooks.fireFluidPlaceBlockEvent(level, pos, pos, Blocks.STONE.defaultBlockState()), 3);
                }

                this.fizz(level, pos);
                return;
            }
        }

        super.spreadTo(level, pos, blockState, direction, fluidState);
    }

    protected boolean isRandomlyTicking() {
        return true;
    }

//    protected float getExplosionResistance() {
//        return 100.0F;
//    }
//
//    public Optional<SoundEvent> getPickupSound() {
//        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
//    }

//    public static class Source extends MoltenFluidTypes {
//        public Source() {
//        }
//
//        public int getAmount(FluidState state) {
//            return 8;
//        }
//
//        public boolean isSource(FluidState state) {
//            return true;
//        }
//    }
//
//    public static class Flowing extends MoltenFluidTypes {
//        public Flowing() {
//        }
//
//        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
//            super.createFluidStateDefinition(builder);
//            builder.add(new Property[]{LEVEL});
//        }
//        @Override
//        public int getAmount(FluidState state) {
//            return (Integer)state.getValue(LEVEL);
//        }
//
//        @Override
//        public boolean isSource(FluidState state) {
//            return false;
//        }
//    }
}
