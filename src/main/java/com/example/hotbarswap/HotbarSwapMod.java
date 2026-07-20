package com.example.hotbarswap;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(HotbarSwapMod.MODID)
public class HotbarSwapMod {

    public static final String MODID = "hotbarswap";

    public HotbarSwapMod(IEventBus modEventBus, ModContainer modContainer) {
        // Rien de spécial à faire ici : les classes annotées @EventBusSubscriber
        // (NetworkHandler, ClientKeys, ClientTickHandler) s'enregistrent automatiquement.
    }
}
