package net.hexcreate;

import net.hexcreate.registry.HexcreateIotaTypeRegistry;
import net.hexcreate.registry.HexcreateItemRegistry;
import net.hexcreate.registry.HexcreatePatternRegistry;
import net.hexcreate.networking.HexcreateNetworking;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class Hexcreate {
    public static final String MOD_ID = "hexcreate";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("HexCreate says hello!");

        HexcreateAbstractions.initPlatformSpecific();
        HexcreateItemRegistry.init();
        HexcreateIotaTypeRegistry.init();
        HexcreatePatternRegistry.init();
		HexcreateNetworking.init();

        LOGGER.info(HexcreateAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
