package net.hexcreate.forge;

import net.hexcreate.HexcreateAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexcreateAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexcreateAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HexcreateConfigForge.init();
    }
}
