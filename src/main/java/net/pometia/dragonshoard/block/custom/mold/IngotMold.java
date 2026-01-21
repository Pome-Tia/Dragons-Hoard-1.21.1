package net.pometia.dragonshoard.block.custom.mold;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

public class IngotMold extends AbstractMoldBlock {
    public IngotMold(Properties properties, MoldInteraction.InteractionMap interactions) {
        super(properties, interactions);
    }

    @Override
    protected MapCodec<? extends AbstractMoldBlock> codec() {
        return null;
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return false;
    }
}
