package net.hexcreate.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.hexcreate.Hexcreate;
import net.hexcreate.item.ItemCreateStaff;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

import static com.simibubi.create.Create.REGISTRATE;
import static net.hexcreate.Hexcreate.id;
import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.item.Items.BUCKET;

public class HexcreateFluidRegistry {
    // Register items through this
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Hexcreate.MOD_ID, Registry.FLUID_REGISTRY);


    public static void init() {
        FLUIDS.register();
    }




    // A new creative tab. Notice how it is one of the few things that are not deferred
    //public static final CreativeModeTab DUMMY_GROUP = CreativeTabRegistry.create(id("dummy_group"), () -> new ItemStack(HexcreateItemRegistry.DUMMY_ITEM.get()));
//    public static final RegistrySupplier<Fluid> LIQUID_AMETHYST = FLUIDS.register("liquid_amethyst", () -> new LavaFluid() {
//                @Override
//                public int getAmount(FluidState fluidState) {
//                    return 0;
//                }
//
//                @Override
//                public boolean isSource(FluidState fluidState) {
//                    return false;
//                }
//            });

    //public static final RegistrySupplier<Item> DUMMY_ITEM = ITEMS.register("dummy_item", () -> new Item(new Item.Properties().tab(DUMMY_GROUP)));


}
