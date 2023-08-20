package com.zyao.rete.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ItemRegistryHandler {
    public static final ItemDollar rete_dollar = new ItemDollar();
    public static final Item_10_Rubles rete_10_rubles = new Item_10_Rubles();
    public static final Item_100_Rubles rete_100_rubles = new Item_100_Rubles();
    public static final Item_1000_Rubles rete_1000_rubles = new Item_1000_Rubles();
    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(rete_dollar);
        registry.register(rete_10_rubles);
        registry.register(rete_100_rubles);
        registry.register(rete_1000_rubles);
    } //这里是实例话物品
    @SubscribeEvent //监听net.minecraftforge.client.event.ModelRegistryEvent事件
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(rete_dollar, 0,
                new ModelResourceLocation(rete_dollar.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(rete_10_rubles, 0,
                new ModelResourceLocation(rete_10_rubles.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(rete_100_rubles, 0,
                new ModelResourceLocation(rete_100_rubles.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(rete_1000_rubles, 0,
                new ModelResourceLocation(rete_1000_rubles.getRegistryName(),"inventory"));
    }
}
