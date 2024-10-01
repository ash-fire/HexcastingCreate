package net.hexcreate.registry;

import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hexcreate.Hexcreate;
import net.hexcreate.block.InfuserBlock;
import net.hexcreate.item.ItemCreateStaff;
import net.hexcreate.item.ItemScryingGoggles;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

import static net.hexcreate.Hexcreate.id;
import static net.hexcreate.registry.HexcreateFluidRegistry.*;

public class HexcreateBlockRegistry {
    // Register items through this
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Hexcreate.MOD_ID, Registry.BLOCK_REGISTRY);
    public static final RegistrySupplier<Block> INFUSER_BLOCK = BLOCKS.register("infuser_block", () -> new InfuserBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(1.5f)));

    public static void init() {
        BLOCKS.register();
    }


    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab DUMMY_GROUP = CreativeTabRegistry.create(id("dummy_group"), () -> new ItemStack(HexcreateItemRegistry.DUMMY_ITEM.get()));


    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    //public static final RegistrySupplier<Item> DUMMY_ITEM = ITEMS.register("dummy_item", () -> new Item(new Item.Properties().tab(DUMMY_GROUP)));


}
