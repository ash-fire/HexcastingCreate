package net.hexcreate.forge;

import net.hexcreate.HexcreateClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexcreateClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexcreateClient.init();
    }
}
