package net.pometia.dragonshoard.block.custom.crystal;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class CrystalStageOneVarThree extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public CrystalStageOneVarThree(Properties properties) {
        super(properties);

    }

    public static final MapCodec<CrystalStageOneVarThree> CODEC = RecordCodecBuilder.mapCodec((p_308798_) -> {
        return p_308798_.group(Codec.FLOAT.fieldOf("height").forGetter((p_304411_) -> {
            return p_304411_.height;
        }), Codec.FLOAT.fieldOf("aabb_offset").forGetter((p_304908_) -> {
            return p_304908_.aabbOffset;
        }), propertiesCodec()).apply(p_308798_, CrystalStageOneVarThree::new);
    });
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    float height;
    float aabbOffset;
    protected VoxelShape northAabb = makeShapeNorth();
    protected VoxelShape southAabb = makeShapeSouth();
    protected VoxelShape eastAabb = makeShapeEast();
    protected VoxelShape westAabb = makeShapeWest();
    protected VoxelShape upAabb = makeShapeUp();
    protected VoxelShape downAabb = makeShapeDown();

    public MapCodec<CrystalStageOneVarThree> codec() {
        return CODEC;
    }

    public CrystalStageOneVarThree(float height, float aabbOffset, Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, false)).setValue(FACING, Direction.UP));
        this.upAabb = Block.box((double)aabbOffset, 0.0, (double)aabbOffset, (double)(16.0F - aabbOffset), (double)height, (double)(16.0F - aabbOffset));
        this.downAabb = Block.box((double)aabbOffset, (double)(16.0F - height), (double)aabbOffset, (double)(16.0F - aabbOffset), 16.0, (double)(16.0F - aabbOffset));
        this.northAabb = Block.box((double)aabbOffset, (double)aabbOffset, (double)(16.0F - height), (double)(16.0F - aabbOffset), (double)(16.0F - aabbOffset), 16.0);
        this.southAabb = Block.box((double)aabbOffset, (double)aabbOffset, 0.0, (double)(16.0F - aabbOffset), (double)(16.0F - aabbOffset), (double)height);
        this.eastAabb = Block.box(0.0, (double)aabbOffset, (double)aabbOffset, (double)height, (double)(16.0F - aabbOffset), (double)(16.0F - aabbOffset));
        this.westAabb = Block.box((double)(16.0F - height), (double)aabbOffset, (double)aabbOffset, 16.0, (double)(16.0F - aabbOffset), (double)(16.0F - aabbOffset));
        this.height = height;
        this.aabbOffset = aabbOffset;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = (Direction)state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case DOWN:
                return this.downAabb;
            case UP:
            default:
                return this.upAabb;
        }
    }

    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = (Direction)state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        return level.getBlockState(blockpos).isFaceSturdy(level, blockpos, direction);
    }

    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction == ((Direction)state.getValue(FACING)).getOpposite() && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        return (BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, context.getClickedFace());
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED, FACING});
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        FACING = BlockStateProperties.FACING;
    }

    public static VoxelShape makeShapeUp(){
        VoxelShape shapeUp = Shapes.empty();
        shapeUp = Shapes.join(shapeUp, Shapes.box(0.4375, 0, 0.4375, 0.625, 0.1875, 0.625), BooleanOp.OR);

        return shapeUp;
    }
    public static VoxelShape makeShapeDown(){
        VoxelShape shapeDown = Shapes.empty();
        shapeDown = Shapes.join(shapeDown, Shapes.box(0.4375, 0.8125, 0.375, 0.625, 1, 0.5625), BooleanOp.OR);

        return shapeDown;
    }
    public static VoxelShape makeShapeNorth(){
        VoxelShape shapeNorth = Shapes.empty();
        shapeNorth = Shapes.join(shapeNorth, Shapes.box(0.4375, 0.4375, 0.8125, 0.625, 0.625, 1), BooleanOp.OR);

        return shapeNorth;
    }
    public static VoxelShape makeShapeEast(){
        VoxelShape shapeEast = Shapes.empty();
        shapeEast = Shapes.join(shapeEast, Shapes.box(0, 0.4375, 0.4375, 0.1875, 0.625, 0.625), BooleanOp.OR);


        return shapeEast;
    }
    public static VoxelShape makeShapeSouth(){
        VoxelShape shapeSouth = Shapes.empty();
        shapeSouth = Shapes.join(shapeSouth, Shapes.box(0.375, 0.4375, 0, 0.5625, 0.625, 0.1875), BooleanOp.OR);


        return shapeSouth;
    }
    public static VoxelShape makeShapeWest(){
        VoxelShape shapeWest = Shapes.empty();
        shapeWest = Shapes.join(shapeWest, Shapes.box(0.8125, 0.4375, 0.375, 1, 0.625, 0.5625), BooleanOp.OR);
        return shapeWest;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        super.animateTick(state, level, pos, rand);
        if (rand.nextInt(10) == 0) {
            BlockPos blockpos = pos.above();
            BlockState blockstate = level.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(level, blockpos, rand, ParticleTypes.END_ROD);
            }
        }
    }
}
