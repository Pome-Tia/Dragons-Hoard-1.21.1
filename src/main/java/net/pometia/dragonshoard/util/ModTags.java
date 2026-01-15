package net.pometia.dragonshoard.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.pometia.dragonshoard.DragonsHoard;

public class ModTags {

    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DragonsHoard.MOD_ID, name));
        }

        // GENERAL
        public static final TagKey<Block> GENERAL_FAVORED_BLOCKS_WOOD = createTag("general_favored_blocks_wood");
        public static final TagKey<Block> GENERAL_FAVORED_BLOCKS_STONE = createTag("general_favored_blocks_stone");
        public static final TagKey<Block> GENERAL_FAVORED_BLOCKS_OTHER = createTag("general_favored_blocks_other");
        public static final TagKey<Block> GENERAL_FAVORED_BLOCKS_COPPER = createTag("general_favored_blocks_copper");
        public static final TagKey<Block> GENERAL_FAVORED_BLOCKS_PLANTS = createTag("general_favored_blocks_plants");

        // JANUARY
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_1 = createTag("jan_favored_blocks_value_1");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_2 = createTag("jan_favored_blocks_value_2");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_3 = createTag("jan_favored_blocks_value_3");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_4 = createTag("jan_favored_blocks_value_4");
        public static final TagKey<Block> JAN_FAVORED_BLOCKS_VALUE_5 = createTag("jan_favored_blocks_value_5");
        // FEBRUARY
        public static final TagKey<Block> FEB_FAVORED_BLOCKS_VALUE_1 = createTag("feb_favored_blocks_value_1");
        public static final TagKey<Block> FEB_FAVORED_BLOCKS_VALUE_2 = createTag("feb_favored_blocks_value_2");
        public static final TagKey<Block> FEB_FAVORED_BLOCKS_VALUE_3 = createTag("feb_favored_blocks_value_3");
        public static final TagKey<Block> FEB_FAVORED_BLOCKS_VALUE_4 = createTag("feb_favored_blocks_value_4");
        public static final TagKey<Block> FEB_FAVORED_BLOCKS_VALUE_5 = createTag("feb_favored_blocks_value_5");
        // MARCH
        public static final TagKey<Block> MAR_FAVORED_BLOCKS_VALUE_1 = createTag("mar_favored_blocks_value_1");
        public static final TagKey<Block> MAR_FAVORED_BLOCKS_VALUE_2 = createTag("mar_favored_blocks_value_2");
        public static final TagKey<Block> MAR_FAVORED_BLOCKS_VALUE_3 = createTag("mar_favored_blocks_value_3");
        public static final TagKey<Block> MAR_FAVORED_BLOCKS_VALUE_4 = createTag("mar_favored_blocks_value_4");
        public static final TagKey<Block> MAR_FAVORED_BLOCKS_VALUE_5 = createTag("mar_favored_blocks_value_5");
        // APRIL
        public static final TagKey<Block> APR_FAVORED_BLOCKS_VALUE_1 = createTag("apr_favored_blocks_value_1");
        public static final TagKey<Block> APR_FAVORED_BLOCKS_VALUE_2 = createTag("apr_favored_blocks_value_2");
        public static final TagKey<Block> APR_FAVORED_BLOCKS_VALUE_3 = createTag("apr_favored_blocks_value_3");
        public static final TagKey<Block> APR_FAVORED_BLOCKS_VALUE_4 = createTag("apr_favored_blocks_value_4");
        public static final TagKey<Block> APR_FAVORED_BLOCKS_VALUE_5 = createTag("apr_favored_blocks_value_5");
        // MAY
        public static final TagKey<Block> MAY_FAVORED_BLOCKS_VALUE_1 = createTag("may_favored_blocks_value_1");
        public static final TagKey<Block> MAY_FAVORED_BLOCKS_VALUE_2 = createTag("may_favored_blocks_value_2");
        public static final TagKey<Block> MAY_FAVORED_BLOCKS_VALUE_3 = createTag("may_favored_blocks_value_3");
        public static final TagKey<Block> MAY_FAVORED_BLOCKS_VALUE_4 = createTag("may_favored_blocks_value_4");
        public static final TagKey<Block> MAY_FAVORED_BLOCKS_VALUE_5 = createTag("may_favored_blocks_value_5");
        // JUNE
        public static final TagKey<Block> JUN_FAVORED_BLOCKS_VALUE_1 = createTag("jun_favored_blocks_value_1");
        public static final TagKey<Block> JUN_FAVORED_BLOCKS_VALUE_2 = createTag("jun_favored_blocks_value_2");
        public static final TagKey<Block> JUN_FAVORED_BLOCKS_VALUE_3 = createTag("jun_favored_blocks_value_3");
        public static final TagKey<Block> JUN_FAVORED_BLOCKS_VALUE_4 = createTag("jun_favored_blocks_value_4");
        public static final TagKey<Block> JUN_FAVORED_BLOCKS_VALUE_5 = createTag("jun_favored_blocks_value_5");
        // JULY
        public static final TagKey<Block> JUL_FAVORED_BLOCKS_VALUE_1 = createTag("jul_favored_blocks_value_1");
        public static final TagKey<Block> JUL_FAVORED_BLOCKS_VALUE_2 = createTag("jul_favored_blocks_value_2");
        public static final TagKey<Block> JUL_FAVORED_BLOCKS_VALUE_3 = createTag("jul_favored_blocks_value_3");
        public static final TagKey<Block> JUL_FAVORED_BLOCKS_VALUE_4 = createTag("jul_favored_blocks_value_4");
        public static final TagKey<Block> JUL_FAVORED_BLOCKS_VALUE_5 = createTag("jul_favored_blocks_value_5");
        // AUGUST
        public static final TagKey<Block> AUG_FAVORED_BLOCKS_VALUE_1 = createTag("aug_favored_blocks_value_1");
        public static final TagKey<Block> AUG_FAVORED_BLOCKS_VALUE_2 = createTag("aug_favored_blocks_value_2");
        public static final TagKey<Block> AUG_FAVORED_BLOCKS_VALUE_3 = createTag("aug_favored_blocks_value_3");
        public static final TagKey<Block> AUG_FAVORED_BLOCKS_VALUE_4 = createTag("aug_favored_blocks_value_4");
        public static final TagKey<Block> AUG_FAVORED_BLOCKS_VALUE_5 = createTag("aug_favored_blocks_value_5");
        // SEPTEMBER
        public static final TagKey<Block> SEP_FAVORED_BLOCKS_VALUE_1 = createTag("sep_favored_blocks_value_1");
        public static final TagKey<Block> SEP_FAVORED_BLOCKS_VALUE_2 = createTag("sep_favored_blocks_value_2");
        public static final TagKey<Block> SEP_FAVORED_BLOCKS_VALUE_3 = createTag("sep_favored_blocks_value_3");
        public static final TagKey<Block> SEP_FAVORED_BLOCKS_VALUE_4 = createTag("sep_favored_blocks_value_4");
        public static final TagKey<Block> SEP_FAVORED_BLOCKS_VALUE_5 = createTag("sep_favored_blocks_value_5");
        // OCTOBER
        public static final TagKey<Block> OCT_FAVORED_BLOCKS_VALUE_1 = createTag("oct_favored_blocks_value_1");
        public static final TagKey<Block> OCT_FAVORED_BLOCKS_VALUE_2 = createTag("oct_favored_blocks_value_2");
        public static final TagKey<Block> OCT_FAVORED_BLOCKS_VALUE_3 = createTag("oct_favored_blocks_value_3");
        public static final TagKey<Block> OCT_FAVORED_BLOCKS_VALUE_4 = createTag("oct_favored_blocks_value_4");
        public static final TagKey<Block> OCT_FAVORED_BLOCKS_VALUE_5 = createTag("oct_favored_blocks_value_5");
        // NOVEMBER
        public static final TagKey<Block> NOV_FAVORED_BLOCKS_VALUE_1 = createTag("nov_favored_blocks_value_1");
        public static final TagKey<Block> NOV_FAVORED_BLOCKS_VALUE_2 = createTag("nov_favored_blocks_value_2");
        public static final TagKey<Block> NOV_FAVORED_BLOCKS_VALUE_3 = createTag("nov_favored_blocks_value_3");
        public static final TagKey<Block> NOV_FAVORED_BLOCKS_VALUE_4 = createTag("nov_favored_blocks_value_4");
        public static final TagKey<Block> NOV_FAVORED_BLOCKS_VALUE_5 = createTag("nov_favored_blocks_value_5");
        // DECEMBER
        public static final TagKey<Block> DEC_FAVORED_BLOCKS_VALUE_1 = createTag("dec_favored_blocks_value_1");
        public static final TagKey<Block> DEC_FAVORED_BLOCKS_VALUE_2 = createTag("dec_favored_blocks_value_2");
        public static final TagKey<Block> DEC_FAVORED_BLOCKS_VALUE_3 = createTag("dec_favored_blocks_value_3");
        public static final TagKey<Block> DEC_FAVORED_BLOCKS_VALUE_4 = createTag("dec_favored_blocks_value_4");
        public static final TagKey<Block> DEC_FAVORED_BLOCKS_VALUE_5 = createTag("dec_favored_blocks_value_5");

    }
}

