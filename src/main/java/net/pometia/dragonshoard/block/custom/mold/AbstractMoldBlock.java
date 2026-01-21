package net.pometia.dragonshoard.block.custom.mold;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractMoldBlock extends Block {
    private static final int SIDE_THICKNESS = 2;
    private static final int LEG_WIDTH = 4;
    private static final int LEG_HEIGHT = 3;
    private static final int LEG_DEPTH = 2;
    protected static final int FLOOR_LEVEL = 4;
    private static final VoxelShape INSIDE = box(2.0, 4.0, 2.0, 14.0, 16.0, 14.0);
    protected static final VoxelShape SHAPE;
    protected final MoldInteraction.InteractionMap interactions;

    protected abstract MapCodec<? extends AbstractMoldBlock> codec();

    public AbstractMoldBlock(BlockBehaviour.Properties properties, MoldInteraction.InteractionMap interactions) {
        super(properties);
        this.interactions = interactions;
    }

    protected double getContentHeight(BlockState state) {
        return 0.0;
    }

//    protected boolean isEntityInsideContent(BlockState state, BlockPos pos, Entity entity) {
//        return entity.getY() < (double)pos.getY() + this.getContentHeight(state) && entity.getBoundingBox().maxY > (double)pos.getY() + 0.25;
//    }

    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        MoldInteraction moldinteraction = (MoldInteraction)this.interactions.map().get(stack.getItem());
        return moldinteraction.interact(state, level, pos, player, hand, stack);
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return INSIDE;
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public abstract boolean isFull(BlockState var1);

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//        BlockPos blockpos = PointedDripstoneBlock.findStalactiteTipAboveMold(level, pos);
//        if (blockpos != null) {
//            Fluid fluid = PointedDripstoneBlock.getMoldFillFluidType(level, blockpos);
//            if (fluid != Fluids.EMPTY && this.canReceiveStalactiteDrip(fluid)) {
//                this.receiveStalactiteDrip(state, level, pos, fluid);
//            }
        }


//    protected boolean canReceiveStalactiteDrip(Fluid fluid) {
//        return false;
//    }
//
//    protected void receiveStalactiteDrip(BlockState state, Level level, BlockPos pos, Fluid fluid) {
//    }

    public void onPlace(BlockState p_51978_, Level p_51979_, BlockPos p_51980_, BlockState p_51981_, boolean p_51982_) {
        super.onPlace(p_51978_, p_51979_, p_51980_, p_51981_, p_51982_);
        if (MoldFluidContent.getForBlock(p_51981_.getBlock()) == null) {
            p_51979_.invalidateCapabilities(p_51980_);
        }

    }

    public void onRemove(BlockState p_60515_, Level p_60516_, BlockPos p_60517_, BlockState p_60518_, boolean p_60519_) {
        super.onRemove(p_60515_, p_60516_, p_60517_, p_60518_, p_60519_);
        if (MoldFluidContent.getForBlock(p_60518_.getBlock()) == null) {
            p_60516_.invalidateCapabilities(p_60517_);
        }

    }

    static {
        SHAPE = Shapes.join(Shapes.block(), Shapes.or(box(0.0, 0.0, 4.0, 16.0, 3.0, 12.0), new VoxelShape[]{box(4.0, 0.0, 0.0, 12.0, 3.0, 16.0), box(2.0, 0.0, 2.0, 14.0, 3.0, 14.0), INSIDE}), BooleanOp.ONLY_FIRST);
    }
    }
