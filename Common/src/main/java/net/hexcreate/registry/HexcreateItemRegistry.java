package net.hexcreate.registry;

import com.simibubi.create.content.equipment.goggles.GogglesItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexcreate.Hexcreate;
import net.hexcreate.item.ItemCreateStaff;
import net.hexcreate.item.ItemScryingGoggles;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;

import static net.hexcreate.Hexcreate.id;

public class HexcreateItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Hexcreate.MOD_ID, Registry.ITEM_REGISTRY);

    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab DUMMY_GROUP = CreativeTabRegistry.create(id("dummy_group"), () -> new ItemStack(HexcreateItemRegistry.DUMMY_ITEM.get()));
    public static final CreativeModeTab HEXCREATE_GROUP = CreativeTabRegistry.create(id("hexcreate_group"), () -> new ItemStack(HexcreateItemRegistry.CREATE_STAFF.get()));

    public static final RegistrySupplier<Item> CREATE_STAFF = ITEMS.register("create_staff", () -> new ItemCreateStaff(new Item.Properties().tab(HEXCREATE_GROUP)));
    public static final RegistrySupplier<Item> SCRYING_GOGGLES = ITEMS.register("scrying_goggles", () -> new ItemScryingGoggles(new Item.Properties().tab(HEXCREATE_GROUP).stacksTo(1)));
    public static final RegistrySupplier<Item> INFUSER_BLOCK_ITEM = ITEMS.register("infuser_block", () -> new BlockItem(HexcreateBlockRegistry.INFUSER_BLOCK.get(), new Item.Properties().tab(HEXCREATE_GROUP)));

    public static final RegistrySupplier<Item> ARTIFICIAL_AMETHYST = ITEMS.register("artificial_amethyst", () -> new Item(new Item.Properties().tab(HEXCREATE_GROUP)));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> DUMMY_ITEM = ITEMS.register("dummy_item", () -> new Item(new Item.Properties().tab(DUMMY_GROUP)));


}
