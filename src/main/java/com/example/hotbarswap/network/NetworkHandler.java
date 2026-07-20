package com.example.hotbarswap.network;

import com.example.hotbarswap.HotbarSwapMod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = HotbarSwapMod.MODID)
public class NetworkHandler {

    // Index du premier slot de la dernière rangée du 3x9, juste au-dessus de la hotbar.
    // Mets 9 ici si tu veux la toute première rangée du haut à la place.
    private static final int ROW_START = 27;

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(
                SwapHotbarPayload.TYPE,
                SwapHotbarPayload.STREAM_CODEC,
                NetworkHandler::handleSwapHotbar
        );
    }

    private static void handleSwapHotbar(SwapHotbarPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer player)) return;
            Inventory inv = player.getInventory();

            for (int i = 0; i < 9; i++) {
                ItemStack hotbarStack = inv.getItem(i);
                ItemStack rowStack = inv.getItem(ROW_START + i);
                inv.setItem(i, rowStack);
                inv.setItem(ROW_START + i, hotbarStack);
            }
            player.containerMenu.broadcastChanges();
        });
    }
}
