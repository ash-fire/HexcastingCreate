package net.hexcreate.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexcreate.Hexcreate;
import net.hexcreate.block.InfuserBlock;
import net.hexcreate.entities.InfuserBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import static net.hexcreate.registry.HexcreateBlockRegistry.INFUSER_BLOCK;


public class HexcreateBlockEntityRegistry {
    // Register items through this
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Hexcreate.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<InfuserBlockEntity>> INFUSER_BLOCK_ENTITY = BLOCK_ENTITIES.register("infuser_block_entity", () -> BlockEntityType.Builder.of(InfuserBlockEntity::new, INFUSER_BLOCK.get()).build(null));

    public static void init() {
        BLOCK_ENTITIES.register();
    }


    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab DUMMY_GROUP = CreativeTabRegistry.create(id("dummy_group"), () -> new ItemStack(HexcreateItemRegistry.DUMMY_ITEM.get()));


    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> DUMMY_ITEM = ITEMS.register("dummy_item", () -> new Item(new Item.Properties().tab(DUMMY_GROUP)));


}
