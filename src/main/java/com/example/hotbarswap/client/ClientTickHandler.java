package com.example.hotbarswap.client;

import com.example.hotbarswap.HotbarSwapMod;
import com.example.hotbarswap.network.SwapHotbarPayload;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = HotbarSwapMod.MODID)
public class ClientTickHandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        while (ClientKeys.SWAP_HOTBAR_KEY.consumeClick()) {
            PacketDistributor.sendToServer(new SwapHotbarPayload());
        }
    }
}
