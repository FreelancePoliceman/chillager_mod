package DukeLeto2.chillager_mod.mixin;

import DukeLeto2.chillager_mod.ChillagerModEntities;
import DukeLeto2.chillager_mod.mobs.ChillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpawnRestriction.class)
public class SpawnRestrictionsMixin {
    @Shadow
    private static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location, Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {

    }

    @Inject(method="<clinit>", at=@At("TAIL"))
    private static void clinit(CallbackInfo ci) {
        register(ChillagerModEntities.CHILLAGER, SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ChillagerEntity::canSpawnChillagerInDark);
    }
}
