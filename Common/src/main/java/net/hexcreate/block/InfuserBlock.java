package net.hexcreate.block;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import net.hexcreate.entities.InfuserBlockEntity;
import net.hexcreate.registry.HexcreateBlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class InfuserBlock extends KineticBlock implements ICogWheel {
    public InfuserBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public float getParticleTargetRadius() {
        return .85f;
    }


    public SpeedLevel getMinimumRequiredSpeedLevel() {
        return SpeedLevel.FAST;
    }

    public Class<InfuserBlockEntity> getBlockEntityClass() {
        return InfuserBlockEntity.class;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new InfuserBlockEntity(pos, state);
    }


    public BlockEntityType<? extends InfuserBlockEntity> getBlockEntityType() {
        return HexcreateBlockEntityRegistry.INFUSER_BLOCK_ENTITY.get();
    }


}
