package com.monky.alstakka;

import com.mojang.logging.LogUtils;
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
import software.bernie.geckolib.GeckoLib;

import static com.monky.alstakka.item.ModItems.ALSTAKKA_SPAWN_EGG;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(com.monky.alstakka.Alstakka.MOD_ID)
public class Alstakka {
    public static final String MOD_ID = "alstakka";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Alstakka() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::buildContents);

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
    public void buildContents(CreativeModeTabEvent.BuildContents event) {
        // Add to ingredients tab
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ALSTAKKA_SPAWN_EGG);
        }
    }
}
