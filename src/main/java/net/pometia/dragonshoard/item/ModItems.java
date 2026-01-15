package net.pometia.dragonshoard.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pometia.dragonshoard.DragonsHoard;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DragonsHoard.MOD_ID);

    // GEMS
    public static final DeferredItem<Item> MOONSTONE_GEM = ITEMS.registerSimpleItem("moonstone_gem");
    public static final DeferredItem<Item> IOLITE_GEM = ITEMS.registerSimpleItem("iolite_gem");
    public static final DeferredItem<Item> AQUAMARINE_GEM = ITEMS.registerSimpleItem("aquamarine_gem");
    public static final DeferredItem<Item> ROSE_QUARTZ_GEM = ITEMS.registerSimpleItem("rose_quartz_gem");
    public static final DeferredItem<Item> VERDELITE_GEM = ITEMS.registerSimpleItem("verdelite_gem");
    public static final DeferredItem<Item> ALEXANDRITE_GEM = ITEMS.registerSimpleItem("alexandrite_gem");
    public static final DeferredItem<Item> RUBY_GEM = ITEMS.registerSimpleItem("ruby_gem");
    public static final DeferredItem<Item> SAPPHIRE_GEM = ITEMS.registerSimpleItem("sapphire_gem");
    public static final DeferredItem<Item> TOURMALINE_GEM = ITEMS.registerSimpleItem("tourmaline_gem");
    public static final DeferredItem<Item> TANZANITE_GEM = ITEMS.registerSimpleItem("tanzanite_gem");
    public static final DeferredItem<Item> CITRINE_GEM = ITEMS.registerSimpleItem("citrine_gem");
    public static final DeferredItem<Item> OPAL_GEM = ITEMS.registerSimpleItem("opal_gem");

    // INGOTS
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");
    public static final DeferredItem<Item> WHITE_GOLD_INGOT = ITEMS.registerSimpleItem("white_gold_ingot");
    public static final DeferredItem<Item> BLUE_GOLD_INGOT = ITEMS.registerSimpleItem("blue_gold_ingot");
    public static final DeferredItem<Item> ROSE_GOLD_INGOT = ITEMS.registerSimpleItem("rose_gold_ingot");
    public static final DeferredItem<Item> STAR_BLUE_GOLD_INGOT = ITEMS.registerSimpleItem("star_blue_gold_ingot");

    // FLOWERS
//    public static final DeferredItem<Item> SNOWDROP = ITEMS.registerSimpleItem("snowdrop");
//    public static final DeferredItem<Item> VIOLETS = ITEMS.registerSimpleItem("violets");
//    public static final DeferredItem<Item> DAFFODIL = ITEMS.registerSimpleItem("daffodil");
//    public static final DeferredItem<Item> LARKSPUR = ITEMS.registerSimpleItem("larkspur");
//    public static final DeferredItem<Item> BLUE_ROSE = ITEMS.registerSimpleItem("blue_rose");
//    public static final DeferredItem<Item> MARIGOLD = ITEMS.registerSimpleItem("marigold");
//    public static final DeferredItem<Item> MORNING_GLORY = ITEMS.registerSimpleItem("morning_glory");
//    public static final DeferredItem<Item> NARCISSUS = ITEMS.registerSimpleItem("narcissus");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
