package net.pometia.dragonshoard.block.custom.mold;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.fluids.CauldronFluidContent;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class RegisterMoldFluidContentEvent extends Event implements IModBusEvent {
    RegisterMoldFluidContentEvent() {
    }

    public void register(Block block, Fluid fluid, int totalAmount, @Nullable IntegerProperty levelProperty) {
        Objects.requireNonNull(block, "Block may not be null");
        Objects.requireNonNull(fluid, "Fluid may not be null");
        MoldFluidContent.register(block, fluid, totalAmount, levelProperty);
    }
}
