package DukeLeto2.chillager_mod.mixin;

/*
@Mixin(PlainsFlowerBlockStateProvider.class)
public class PlainsFlowerBlockStateProviderMixin {
    @Inject(method="<clinit>", at=@At("TAIL"))
    private static void clinit(CallbackInfo ci) {
        BlockState flowercopy[] = PlainsFlowerBlockStateProviderInterface.getFLOWERS();
        BlockState newcopy[] = Arrays.copyOf(flowercopy, flowercopy.length + 1);
        newcopy[newcopy.length - 1] = BlocksEveryoneWon.BUTTERCUP_BLOCK.getDefaultState();
        PlainsFlowerBlockStateProviderInterface.setFlowers(newcopy);
    }
}
*/