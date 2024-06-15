package net.hexcreate.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexcreate.Hexcreate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(Hexcreate.MOD_ID)
public class HexcreateForge {
    public HexcreateForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Hexcreate.MOD_ID, bus);
        bus.addListener(HexcreateClientForge::init);
        Hexcreate.init();
    }
}
