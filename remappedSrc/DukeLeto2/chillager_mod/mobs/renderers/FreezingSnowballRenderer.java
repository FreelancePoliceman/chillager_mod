package DukeLeto2.chillager_mod.mobs.renderers;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class FreezingSnowballRenderer extends ProjectileEntityRenderer {

    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/item/snowball.png");

    public FreezingSnowballRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }
}
