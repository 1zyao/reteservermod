package com.zyao.rete.item;

import com.zyao.rete.creativetab.Tab;
import com.zyao.rete.rete;
import net.minecraft.item.Item;
public class Item_1000_Rubles extends Item {
    public Item_1000_Rubles() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName(rete.MODID + ".rubles.1000");
        this.setRegistryName("rete_1000_Rubles");
        this.setCreativeTab(Tab.TAB_RETE);
    }
}