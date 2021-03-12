package DukeLeto2.chillager_mod;

import DukeLeto2.chillager_mod.entities.FreezingSnowball;
import DukeLeto2.chillager_mod.mobs.ChillagerEntity;
//import DukeLeto2.chillager_mod.mobs.MooBloomEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;

import static DukeLeto2.chillager_mod.ChillagerMod.CONFIG;

public class ChillagerModEntities {
    //   public static final EntityType<MooBloomEntity> MOOBLOOM = Registry.register(Registry.ENTITY_TYPE,
  //          new Identifier(ChillagerMod.modid, "moobloom"), FabricEntityTypeBuilder.<MooBloomEntity>create(SpawnGroup.CREATURE, MooBloomEntity::new).dimensions(EntityDimensions.fixed(0.95f,1.3f)).build());
    public static final EntityType<ChillagerEntity> CHILLAGER = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(ChillagerMod.modid, "chillager"), FabricEntityTypeBuilder.<ChillagerEntity>create(SpawnGroup.MONSTER, ChillagerEntity::new).dimensions(EntityDimensions.fixed(0.6F,1.95F)).build());
    public static final  EntityType<FreezingSnowball> FREEZING_SNOWBALL = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(ChillagerMod.modid, "freezing_snowball"), FabricEntityTypeBuilder.<FreezingSnowball>create(SpawnGroup.MISC, FreezingSnowball::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());
    private static final int weight = CONFIG.getOrDefault("weight", 30);
    public static void register() {
    //    FabricDefaultAttributeRegistry.register(MOOBLOOM, MooBloomEntity.createCowAttributes());
        FabricDefaultAttributeRegistry.register(CHILLAGER, ChillagerEntity.createChillagerAttributes());
    //    BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.FLOWER_FOREST), SpawnGroup.CREATURE, MOOBLOOM, 8, 4, 8);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.SNOWY_MOUNTAINS),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.SNOWY_TAIGA_HILLS),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.SNOWY_TAIGA_MOUNTAINS),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.MOUNTAINS),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.MOUNTAIN_EDGE),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);
        BiomeModifications.addSpawn((ctx) -> ctx.getBiomeKey().equals(BiomeKeys.TAIGA_MOUNTAINS),SpawnGroup.MONSTER,CHILLAGER, weight, 1,1);

        //   FREEZING_SNOWBALL = Registry.register(new Identifier(EveryoneWon.modid, "freezing_snowball"), EntityType.Builder.create(FreezingSnowball::new, SpawnGroup.MISC).setDimensions(0.25F, 0.25F).maxTrackingRange(4).trackingTickInterval(10));

    }
}
