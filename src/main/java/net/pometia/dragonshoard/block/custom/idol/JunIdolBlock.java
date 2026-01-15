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
import net.pometia.dragonshoard.block.entity.custom.idol.JunIdolBlockEntity;
import org.jetbrains.annotations.Nullable;

public class JunIdolBlock extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    public static final MapCodec<JunIdolBlock> CODEC = simpleCodec(JunIdolBlock::new);

    public JunIdolBlock(Properties properties) {
        super(properties);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new JunIdolBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (type == ModBlockEntities.JUN_IDOL_BE.get()) {
            return (level1, pos, state1, blockEntity) -> {
                if (blockEntity instanceof JunIdolBlockEntity be && !level.isClientSide) {
                    JunIdolBlockEntity.serverTick(level1, pos, state1, be);

                } else if (blockEntity instanceof JunIdolBlockEntity be && level.isClientSide) {
                    JunIdolBlockEntity.clientTick(level1, pos, state1, be);

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
