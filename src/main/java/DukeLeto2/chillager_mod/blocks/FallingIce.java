package DukeLeto2.chillager_mod.blocks;

import DukeLeto2.chillager_mod.entities.FallingIceEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FallingIce extends FallingBlock {
    public FallingIce(Settings settings) {
        super(settings);
    }

  //  @Override //Used to override configureFallingBlockEntity
    protected void configureFallingIceEntity(FallingIceEntity entity) {
        entity.setHurtEntities(true);
    }

    @Override
    public void onLanding (World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        this.replace(this.getDefaultState(), Blocks.AIR.getDefaultState(), fallingBlockEntity.world, fallingBlockEntity.getBlockPos(), 0);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (canFallThrough(world.getBlockState(pos.down())) && pos.getY() >= 0) {
            FallingIceEntity fallingBlockEntity = new FallingIceEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, world.getBlockState(pos));
            this.configureFallingIceEntity(fallingBlockEntity);
            world.spawnEntity(fallingBlockEntity);
        }
    }
}
