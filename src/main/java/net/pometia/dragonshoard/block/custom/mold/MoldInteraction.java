package net.pometia.dragonshoard.block.custom.mold;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.fluid.ModFluids;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public interface MoldInteraction {
    Map<String, InteractionMap> INTERACTIONS = new Object2ObjectArrayMap();
    Codec<InteractionMap> CODEC;
    InteractionMap EMPTY;
    InteractionMap MOLTEN_GOLD;
    InteractionMap MOLTEN_SILVER;
    InteractionMap MOLTEN_COPPER;
    InteractionMap MOLTEN_ROSE_GOLD;
    InteractionMap MOLTEN_WHITE_GOLD;
    InteractionMap MOLTEN_BLUE_GOLD;
    InteractionMap MOLTEN_STAR_GOLD;
    MoldInteraction FILL_GOLD;
    MoldInteraction FILL_SILVER;
    MoldInteraction FILL_COPPER;
    MoldInteraction FILL_ROSE_GOLD;
    MoldInteraction FILL_WHITE_GOLD;
    MoldInteraction FILL_BLUE_GOLD;
    MoldInteraction FILL_STAR_GOLD;

    static InteractionMap newInteractionMap(String name) {
        Object2ObjectOpenHashMap<Item, MoldInteraction> object2objectopenhashmap = new Object2ObjectOpenHashMap<>();
        object2objectopenhashmap.defaultReturnValue((BlockState, Level, BlockPos, Player, InteractionHand, ItemStack) -> {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        });
        InteractionMap moldinteraction$interactionmap = new InteractionMap(name, object2objectopenhashmap);
        INTERACTIONS.put(name, moldinteraction$interactionmap);
        return moldinteraction$interactionmap;
    }

    ItemInteractionResult interact(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack stack);

    static void bootStrap() {
        Map<Item, MoldInteraction> map = EMPTY.map();
        addDefaultInteractions(map);
        //
        Map<Item, MoldInteraction> gold_map = MOLTEN_GOLD.map();
        gold_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(gold_map);
        //
        Map<Item, MoldInteraction> silver_map = MOLTEN_SILVER.map();
        silver_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(silver_map);
        //
        Map<Item, MoldInteraction> copper_map = MOLTEN_COPPER.map();
        copper_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(copper_map);
        //
        Map<Item, MoldInteraction> rose_gold_map = MOLTEN_ROSE_GOLD.map();
        rose_gold_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(rose_gold_map);
        //
        Map<Item, MoldInteraction> white_gold_map = MOLTEN_WHITE_GOLD.map();
        white_gold_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(white_gold_map);
        //
        Map<Item, MoldInteraction> blue_gold_map = MOLTEN_BLUE_GOLD.map();
        blue_gold_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(blue_gold_map);
        //
        Map<Item, MoldInteraction> star_gold_map = MOLTEN_STAR_GOLD.map();
        star_gold_map.put(Items.BUCKET, (p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_) -> {
            return fillCrucible(p_315889_, p_315890_, p_315891_, p_315892_, p_315893_, p_315894_, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> {
                return true;
            }, SoundEvents.BUCKET_FILL_LAVA);
        });
        addDefaultInteractions(star_gold_map);
    }

    static void addDefaultInteractions(Map<Item, MoldInteraction> interactionsMap) {
        interactionsMap.put(ModFluids.MOLTEN_GOLD_BUCKET.get(), FILL_GOLD);
        interactionsMap.put(ModFluids.MOLTEN_SILVER_BUCKET.get(), FILL_SILVER);
        interactionsMap.put(ModFluids.MOLTEN_COPPER_BUCKET.get(), FILL_COPPER);
        interactionsMap.put(ModFluids.MOLTEN_ROSE_GOLD_BUCKET.get(), FILL_ROSE_GOLD);
        interactionsMap.put(ModFluids.MOLTEN_WHITE_GOLD_BUCKET.get(), FILL_WHITE_GOLD);
        interactionsMap.put(ModFluids.MOLTEN_BLUE_GOLD_BUCKET.get(), FILL_BLUE_GOLD);
        interactionsMap.put(ModFluids.MOLTEN_STAR_GOLD_BUCKET.get(), FILL_STAR_GOLD);
    }

    static ItemInteractionResult fillCrucible(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack emptyStack, ItemStack filledStack, Predicate<BlockState> statePredicate, SoundEvent fillSound) {
        if (!statePredicate.test(state)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            if (!level.isClientSide) {
                Item item = emptyStack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(emptyStack, player, filledStack));
                level.setBlockAndUpdate(pos, ModBlocks.EMPTY_MOLD.get().defaultBlockState());
                level.playSound((Player) null, pos, fillSound, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent((Entity) null, GameEvent.FLUID_PICKUP, pos);
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    static ItemInteractionResult emptyCrucible(Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack, BlockState state, SoundEvent emptySound) {
        if (!level.isClientSide) {
            Item item = filledStack.getItem();
            player.setItemInHand(hand, ItemUtils.createFilledResult(filledStack, player, new ItemStack(Items.BUCKET)));
            level.setBlockAndUpdate(pos, state);
            level.playSound((Player) null, pos, emptySound, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent((Entity) null, GameEvent.FLUID_PLACE, pos);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    static {
        Function var10000 = InteractionMap::name;
        Map var10001 = INTERACTIONS;
        Objects.requireNonNull(var10001);
        CODEC = Codec.stringResolver(var10000, var10001::get);
        EMPTY = newInteractionMap("empty");
        MOLTEN_GOLD = newInteractionMap("molten_gold");
        MOLTEN_SILVER = newInteractionMap("molten_silver");
        MOLTEN_COPPER = newInteractionMap("molten_copper");
        MOLTEN_ROSE_GOLD = newInteractionMap("molten_rose_gold");
        MOLTEN_WHITE_GOLD = newInteractionMap("molten_white_gold");
        MOLTEN_BLUE_GOLD = newInteractionMap("molten_blue_gold");
        MOLTEN_STAR_GOLD = newInteractionMap("molten_star_gold");
        FILL_GOLD = (p_315853_, p_315854_, p_315855_, p_315856_, p_315857_, p_315858_) -> {
            return emptyCrucible(p_315854_, p_315855_, p_315856_, p_315857_, p_315858_, ModBlocks.MOLTEN_GOLD_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_SILVER = (p_315871_, p_315872_, p_315873_, p_315874_, p_315875_, p_315876_) -> {
            return emptyCrucible(p_315872_, p_315873_, p_315874_, p_315875_, p_315876_, (BlockState)ModBlocks.MOLTEN_SILVER_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_COPPER = (p_315871_, p_315872_, p_315873_, p_315874_, p_315875_, p_315876_) -> {
            return emptyCrucible(p_315872_, p_315873_, p_315874_, p_315875_, p_315876_, (BlockState)ModBlocks.MOLTEN_COPPER_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_ROSE_GOLD = (p_315853_, p_315854_, p_315855_, p_315856_, p_315857_, p_315858_) -> {
            return emptyCrucible(p_315854_, p_315855_, p_315856_, p_315857_, p_315858_, ModBlocks.MOLTEN_ROSE_GOLD_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_WHITE_GOLD = (p_315853_, p_315854_, p_315855_, p_315856_, p_315857_, p_315858_) -> {
            return emptyCrucible(p_315854_, p_315855_, p_315856_, p_315857_, p_315858_, ModBlocks.MOLTEN_WHITE_GOLD_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_BLUE_GOLD = (p_315853_, p_315854_, p_315855_, p_315856_, p_315857_, p_315858_) -> {
            return emptyCrucible(p_315854_, p_315855_, p_315856_, p_315857_, p_315858_, ModBlocks.MOLTEN_BLUE_GOLD_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
        FILL_STAR_GOLD = (p_315853_, p_315854_, p_315855_, p_315856_, p_315857_, p_315858_) -> {
            return emptyCrucible(p_315854_, p_315855_, p_315856_, p_315857_, p_315858_, ModBlocks.MOLTEN_STAR_GOLD_MOLD.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY_LAVA);
        };
    }


    public static record InteractionMap(String name, Map<Item, MoldInteraction> map) {
        public InteractionMap(String name, Map<Item, MoldInteraction> map) {
            this.name = name;
            this.map = map;
        }

        public String name() {
            return this.name;
        }

        public Map<Item, MoldInteraction> map() {
            return this.map;
        }
    }
}

