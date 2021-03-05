package DukeLeto2.chillager_mod.mobs.renderers;

import DukeLeto2.chillager_mod.ChillagerMod;
import DukeLeto2.chillager_mod.mobs.ChillagerEntity;
import DukeLeto2.chillager_mod.mobs.renderers.models.ChillagerEntityModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.util.Identifier;

public class ChillagerEntityRenderer <T extends ChillagerEntity> extends MobEntityRenderer<T, ChillagerEntityModel<T>> {
    private static Identifier TEXTURE = new Identifier(ChillagerMod.modid, "textures/entity/chillager/chillager.png");
    public ChillagerEntityRenderer(EntityRenderDispatcher dispatcher, ChillagerEntityModel<T> model, float f) {
        super(dispatcher, model, f);
        this.addFeature(new HeadFeatureRenderer(this));
    }

  /*  @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }*/

    @Override
    public Identifier getTexture(T entity) {
        return TEXTURE;
    }
}
