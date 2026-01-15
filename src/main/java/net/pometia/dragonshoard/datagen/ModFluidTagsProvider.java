package net.pometia.dragonshoard.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.fluid.ModFluids;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {

    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, DragonsHoard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_GOLD.get()).add(ModFluids.FLOWING_MOLTEN_GOLD.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_SILVER.get()).add(ModFluids.FLOWING_MOLTEN_SILVER.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_WHITE_GOLD.get()).add(ModFluids.FLOWING_MOLTEN_WHITE_GOLD.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_BLUE_GOLD.get()).add(ModFluids.FLOWING_MOLTEN_BLUE_GOLD.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_ROSE_GOLD.get()).add(ModFluids.FLOWING_MOLTEN_ROSE_GOLD.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_STAR_GOLD.get()).add(ModFluids.FLOWING_MOLTEN_STAR_GOLD.get());
        tag(FluidTags.LAVA).add(ModFluids.SOURCE_MOLTEN_COPPER.get()).add(ModFluids.FLOWING_MOLTEN_COPPER.get());
    }
}
