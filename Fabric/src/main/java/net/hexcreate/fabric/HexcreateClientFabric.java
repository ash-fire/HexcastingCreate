package net.hexcreate.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexcreate.HexcreateClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexcreateClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexcreateClient.init();
    }
}
