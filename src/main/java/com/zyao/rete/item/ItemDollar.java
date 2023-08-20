package com.zyao.rete.item;

import com.zyao.rete.rete;
import net.minecraft.item.Item;

public class ItemDollar extends Item {
    public ItemDollar() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName(rete.MODID + ".dollar");
        this.setRegistryName("rete_dollar");
    }
}