package com.zyao.rete.item;

import com.zyao.rete.creativetab.Tab;
import com.zyao.rete.rete;
import net.minecraft.item.Item;
public class Item_100_Rubles extends Item {
    public Item_100_Rubles() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName(rete.MODID + ".rubles.100");
        this.setRegistryName("rete_100_Rubles");
        this.setCreativeTab(Tab.TAB_RETE);
    }
}