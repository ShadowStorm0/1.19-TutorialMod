package io.github.shadowstorm0.tutorialmod.block;

import io.github.shadowstorm0.tutorialmod.TutorialMod;
import io.github.shadowstorm0.tutorialmod.item.ModCreativeModeTab;
import io.github.shadowstorm0.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> TITANIUM_BLOCK = registryBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(20f).requiresCorrectToolForDrops().explosionResistance(6))
                    , ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> TITANIUM_ORE = registryBlock("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(6f),
                    UniformInt.of(4, 8)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registryBlock("deepslate_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(6f),
                    UniformInt.of(6, 10)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> NETHERRACK_TITANIUM_ORE = registryBlock("netherrack_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(6f),
                    UniformInt.of(8, 12)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> ENDSTONE_TITANIUM_ORE = registryBlock("endstone_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().explosionResistance(6f),
                    UniformInt.of(10, 14)), ModCreativeModeTab.TUTORIAL_TAB);

    //Register Block
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Register Block Item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
