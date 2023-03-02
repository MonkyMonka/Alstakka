package com.monky.alstakka.event;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.entity.ModEntityTypes;
import com.monky.alstakka.entity.custom.AlstakkaEntity;
import com.monky.alstakka.entity.custom.DipEntity;
import com.monky.alstakka.entity.custom.DupeEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Alstakka.MOD_ID)
    public static class ForgeEvents {
    }

    @Mod.EventBusSubscriber(modid = Alstakka.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.ALSTAKKA.get(), AlstakkaEntity.getAlstakkaAttributes());
            event.put(ModEntityTypes.DUPE.get(), DupeEntity.getDupeAttributes().build());
            event.put(ModEntityTypes.DIP.get(), DipEntity.getDipAttributes().build());
        }
    }
}
