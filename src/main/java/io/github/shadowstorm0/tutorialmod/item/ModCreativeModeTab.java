package io.github.shadowstorm0.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    //Mod Tabs
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("tutorialtab"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TITANIUM.get());
        }
    };
}
