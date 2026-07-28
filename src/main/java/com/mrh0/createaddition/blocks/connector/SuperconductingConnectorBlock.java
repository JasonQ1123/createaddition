package com.mrh0.createaddition.blocks.connector;

import com.mrh0.createaddition.blocks.connector.base.AbstractConnectorBlock;
import com.mrh0.createaddition.index.CABlockEntities;
import com.mrh0.createaddition.shapes.CAShapes;
import net.createmod.catnip.math.VoxelShaper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SuperconductingConnectorBlock extends AbstractConnectorBlock<SuperconductingConnectorBlockEntity> {
    public static final VoxelShaper CONNECTOR_SHAPE = CAShapes.shape(5, 0, 5, 11, 7, 11).forDirectional();
    public SuperconductingConnectorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Class<SuperconductingConnectorBlockEntity> getBlockEntityClass() {
        return SuperconductingConnectorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends SuperconductingConnectorBlockEntity> getBlockEntityType() {
        return CABlockEntities.SUPERCONDUCTING_CONNECTOR.get();
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CABlockEntities.SUPERCONDUCTING_CONNECTOR.create(pos, state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return CONNECTOR_SHAPE.get(state.getValue(FACING).getOpposite());
    }
}