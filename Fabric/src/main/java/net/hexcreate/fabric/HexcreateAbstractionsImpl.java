package net.hexcreate.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexcreate.HexcreateAbstractions;

import java.nio.file.Path;

public class HexcreateAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexcreateAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HexcreateConfigFabric.init();
    }
}
