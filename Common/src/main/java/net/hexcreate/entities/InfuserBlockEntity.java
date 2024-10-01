package net.hexcreate.entities;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.hexcreate.registry.HexcreateBlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class InfuserBlockEntity extends KineticBlockEntity {
    private ItemStack input = ItemStack.EMPTY;
    private ItemStack output = ItemStack.EMPTY;

    public InfuserBlockEntity(BlockPos pos, BlockState state) {
        super(HexcreateBlockEntityRegistry.INFUSER_BLOCK_ENTITY.get(), pos, state);
    }

    // ...

    @Override
    public void tick() {
        super.tick();

        // Check for valid input and output slots
        // Check for enough energy
        // If conditions are met, start processing
        // Update input and output stacks
    }

    // Methods for interacting with the world to get/set items
}