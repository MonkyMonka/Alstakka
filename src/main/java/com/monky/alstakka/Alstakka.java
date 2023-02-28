package com.monky.alstakka;

import com.monky.alstakka.block.ModBlocks;
import com.monky.alstakka.client.render.entity.AlstakkaRenderer;
import com.monky.alstakka.entity.ModEntityTypes;
import com.monky.alstakka.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

@Mod(com.monky.alstakka.Alstakka.MOD_ID)
public class Alstakka {
    public static final String MOD_ID = "alstakka";
    public static final Logger LOGGER = LoggerFactory.getLogger("alstakka");

    public Alstakka() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.ALSTAKKA.get(), AlstakkaRenderer::new);
        }
    }

    @SubscribeEvent
    public void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.ALSTAKKA_SPAWN_EGG);
        }
        if (event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.BOTTLE_RACK_BLOCK);
        }
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.TOKEN_ITEM);
        }
    }
}
