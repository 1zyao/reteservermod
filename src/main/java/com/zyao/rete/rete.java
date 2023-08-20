package com.zyao.rete;

import com.zyao.rete.item.ItemRegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = rete.MODID, name = rete.NAME, version = rete.VERSION, guiFactory = rete.GUIFACTORG)
public class rete {
    public static final String MODID = "rete";
    public static final String NAME = "RETE Server Mod";
    public static final String VERSION = "1.0";
    public static final String GUIFACTORG = "com.zyao.rete.reteConfigGuiFactory";

    public rete() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        //noinspection InstantiationOfUtilityClass
        new reteConfig(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ModEvents {

        @SubscribeEvent
        public static void onPlayerDeath(LivingDeathEvent event) {
            Entity victim = event.getEntity();
            Entity killer = event.getSource().getTrueSource();
            if (victim instanceof EntityPlayer || killer instanceof EntityPlayer) {
                if (killer != null) {
                    if (reteConfig.killgetitem) {
                        giveitem((EntityPlayer) killer);
                    }
                }
            }
        }

        /*
        public static void giveitem(EntityPlayer player) throws IOException {
            String item = reteConfig.item;
            try {
                Field field = ItemRegistryHandler.class.getField(item);
                Object value = field.get(null);

                if (value instanceof Item_10_Rubles) {
                    Item_10_Rubles reteDollarItem = (Item_10_Rubles) value;
                    int number = reteConfig.number;
                    ItemStack diamond = new ItemStack(ItemRegistryHandler.rete_10_rubles, number);
                    player.inventory.addItemStackToInventory(diamond);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
        public static void giveitem(EntityPlayer player) {
            int number = reteConfig.number;
            ItemStack diamond = new ItemStack(ItemRegistryHandler.rete_10_rubles, number);
            player.inventory.addItemStackToInventory(diamond);
        }
    }
}
