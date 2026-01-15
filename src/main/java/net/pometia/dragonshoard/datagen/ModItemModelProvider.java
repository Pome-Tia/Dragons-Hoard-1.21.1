package net.pometia.dragonshoard.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pometia.dragonshoard.DragonsHoard;
import net.pometia.dragonshoard.fluid.ModFluids;
import net.pometia.dragonshoard.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DragonsHoard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // GEMS
        basicItem(ModItems.MOONSTONE_GEM.get());
        basicItem(ModItems.IOLITE_GEM.get());
        basicItem(ModItems.AQUAMARINE_GEM.get());
        basicItem(ModItems.ROSE_QUARTZ_GEM.get());
        basicItem(ModItems.VERDELITE_GEM.get());
        basicItem(ModItems.ALEXANDRITE_GEM.get());
        basicItem(ModItems.RUBY_GEM.get());
        basicItem(ModItems.SAPPHIRE_GEM.get());
        basicItem(ModItems.TOURMALINE_GEM.get());
        basicItem(ModItems.TANZANITE_GEM.get());
        basicItem(ModItems.CITRINE_GEM.get());
        basicItem(ModItems.OPAL_GEM.get());
        // INGOT
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.WHITE_GOLD_INGOT.get());
        basicItem(ModItems.BLUE_GOLD_INGOT.get());
        basicItem(ModItems.ROSE_GOLD_INGOT.get());
        basicItem(ModItems.STAR_BLUE_GOLD_INGOT.get());
        // FLUIDS
        basicItem(ModFluids.MOLTEN_GOLD_BUCKET.get());
        basicItem(ModFluids.MOLTEN_SILVER_BUCKET.get());
        basicItem(ModFluids.MOLTEN_COPPER_BUCKET.get());
        basicItem(ModFluids.MOLTEN_WHITE_GOLD_BUCKET.get());
        basicItem(ModFluids.MOLTEN_BLUE_GOLD_BUCKET.get());
        basicItem(ModFluids.MOLTEN_ROSE_GOLD_BUCKET.get());
        basicItem(ModFluids.MOLTEN_STAR_GOLD_BUCKET.get());

    }
}
