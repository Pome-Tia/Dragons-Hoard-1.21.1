package net.pometia.dragonshoard.block.custom.idol;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.pometia.dragonshoard.block.entity.ModBlockEntities;
import net.pometia.dragonshoard.block.entity.custom.idol.NovIdolBlockEntity;
import org.jetbrains.annotations.Nullable;

public class NovIdolBlock extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    public static final MapCodec<NovIdolBlock> CODEC = simpleCodec(NovIdolBlock::new);

    public NovIdolBlock(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new NovIdolBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type == ModBlockEntities.NOV_IDOL_BE.get()) {
            return (level1, pos, state1, blockEntity) -> {
                if (blockEntity instanceof NovIdolBlockEntity be && !level.isClientSide) {
                    NovIdolBlockEntity.serverTick(level1, pos, state1, be);

                } else if (blockEntity instanceof NovIdolBlockEntity be && level.isClientSide) {
                    NovIdolBlockEntity.clientTick(level1, pos, state1, be);

                }
            };
        }
        return null;
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}