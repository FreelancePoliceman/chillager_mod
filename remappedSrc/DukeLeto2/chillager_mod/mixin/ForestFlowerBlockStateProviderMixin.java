package DukeLeto2.chillager_mod.mixin;

/*import DukeLeto2.chillager_mod.mixin.interfaces.ForestFlowerBlockStateProviderInterface;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;
import net.minecraft.world.gen.stateprovider.ForestFlowerBlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Random;

@Mixin (ForestFlowerBlockStateProvider.class)
public class ForestFlowerBlockStateProviderMixin extends BlockStateProvider {

    @Inject(method="<clinit>", at=@At("TAIL"))
    private static void clinit(CallbackInfo ci) {
        BlockState flowercopy[] = ForestFlowerBlockStateProviderInterface.getFLOWERS();
        BlockState newcopy[] = Arrays.copyOf(flowercopy, flowercopy.length + 1);
        newcopy[newcopy.length - 1] = Blocks.DANDELION.getDefaultState();
        ForestFlowerBlockStateProviderInterface.setFlowers(newcopy);
    }

    @Shadow
    protected BlockStateProviderType<?> getType() {
        return null;
    }

    @Shadow
    public BlockState getBlockState(Random random, BlockPos pos) {
        return null;
    }
} */
