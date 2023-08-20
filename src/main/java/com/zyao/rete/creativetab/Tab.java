package com.zyao.rete.creativetab;

import com.zyao.rete.item.ItemRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tab extends CreativeTabs {
    public static final Tab TAB_RETE = new Tab();
    public Tab(){
        super("rete");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.rete_dollar);
    }
}
