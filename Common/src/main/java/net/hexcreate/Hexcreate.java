package net.hexcreate;

import at.petrak.hexcasting.api.misc.DiscoveryHandlers;
import at.petrak.hexcasting.common.lib.HexItems;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import net.hexcreate.registry.*;
import net.hexcreate.networking.HexcreateNetworking;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
//Amythest liquid -> 1 bucket = 1 Block, 1 shard = 100 mB
    // Can craft amythest liquid, can press it into blocks, can crush blocks into shards
    //super heat amythest shards to form liquid amythest

public class Hexcreate {
    public static final String MOD_ID = "hexcreate";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("HexCreate says hello!");
        HexcreateFluidRegistry.init();
        LOGGER.info("Finished FLUIDS");
        HexcreateBlockRegistry.init();
        LOGGER.info("Finished BLOCKS");
        HexcreateAbstractions.initPlatformSpecific();
        HexcreateItemRegistry.init();
        LOGGER.info("Finished ITEMS");
        HexcreateIotaTypeRegistry.init();
        HexcreatePatternRegistry.init();
		HexcreateNetworking.init();




        LOGGER.info(HexcreateAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
        LOGGER.info("Finished init");

        GogglesItem.addIsWearingPredicate(player -> {
            ItemStack headSlotItem = player.getItemBySlot(EquipmentSlot.HEAD);
            return headSlotItem.getItem() == HexcreateItemRegistry.SCRYING_GOGGLES.get();
        });
        DiscoveryHandlers.addLensPredicate((player) -> player.getItemBySlot(EquipmentSlot.HEAD).is(HexcreateItemRegistry.SCRYING_GOGGLES.get()));
        /** Uncomment to make goggles change grid scale
        DiscoveryHandlers.addGridScaleModifier((player) -> {
            return player.getItemBySlot(EquipmentSlot.HEAD).is(HexcreateItemRegistry.SCRYING_GOGGLES.get()) ? 0.75F : 1.0F;
        });
        **/

    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
