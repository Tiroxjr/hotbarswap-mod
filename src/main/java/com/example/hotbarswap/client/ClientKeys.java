package com.example.hotbarswap.client;

import com.example.hotbarswap.HotbarSwapMod;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

@EventBusSubscriber(modid = HotbarSwapMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientKeys {

    public static final KeyMapping SWAP_HOTBAR_KEY = new KeyMapping(
            "key.hotbarswap.swap",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_R, // touche par défaut, modifiable dans Options > Contrôles > Touches
            "key.categories.hotbarswap"
    );

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(SWAP_HOTBAR_KEY);
    }
}
