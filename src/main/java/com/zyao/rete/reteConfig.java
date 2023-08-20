package com.zyao.rete;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = "rete")
@Config.LangKey("config.rete.general")
public class reteConfig
{
    private static Configuration config;


    @Config.Comment("open killgetitem?")
    @Config.LangKey("config.rete.general.killgetitem")
    public static boolean killgetitem = true;

    @Config.Comment("How much reward")
    @Config.LangKey("config.rete.general.number")
    @Config.RangeInt(min = 1, max = 64)
    public static int number = 1;

    @Config.Comment("item")
    @Config.LangKey("config.rete.general.item")
    public static String item = "rete_10_rubles";

    public reteConfig(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        config.save();
    }
    @Mod.EventBusSubscriber(modid = rete.MODID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(rete.MODID)) {
                ConfigManager.sync(rete.MODID, Config.Type.INSTANCE);
            }
        }
    }
}