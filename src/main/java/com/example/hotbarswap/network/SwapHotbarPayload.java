package com.example.hotbarswap.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record SwapHotbarPayload() implements CustomPacketPayload {

    public static final Type<SwapHotbarPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath("hotbarswap", "swap_hotbar"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SwapHotbarPayload> STREAM_CODEC =
            StreamCodec.unit(new SwapHotbarPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
