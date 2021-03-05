package DukeLeto2.chillager_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import DukeLeto2.chillager_mod.mobs.renderers.ChillagerEntityRenderer;
import DukeLeto2.chillager_mod.mobs.renderers.models.ChillagerEntityModel;
import DukeLeto2.chillager_mod.mobs.renderers.FreezingSnowballRenderer;
//import DukeLeto2.chillager_mod.mobs.renderers.MoobloomEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class ChillagerModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    //    EntityRendererRegistry.INSTANCE.register(ChillagerModEntities.MOOBLOOM, ((entityRenderDispatcher, context) -> {return new MoobloomEntityRenderer(entityRenderDispatcher);
    //    }));
        EntityRendererRegistry.INSTANCE.register(ChillagerModEntities.CHILLAGER, ((entityRenderDispatcher, context) -> {return new ChillagerEntityRenderer(entityRenderDispatcher, new ChillagerEntityModel<>(0,0,64,64), 0.5F);
        }));
        EntityRendererRegistry.INSTANCE.register(ChillagerModEntities.FREEZING_SNOWBALL, (((entityRenderDispatcher, context) -> {
            return new FreezingSnowballRenderer(entityRenderDispatcher);
        })));
    }
}
