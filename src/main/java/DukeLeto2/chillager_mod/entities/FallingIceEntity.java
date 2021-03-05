package DukeLeto2.chillager_mod.entities;

import com.google.common.collect.Lists;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class FallingIceEntity extends FallingBlockEntity {
    public static final DamageSource DAMAGE_FROM_ICE = (new DamageSource("falling_ice"));
    private boolean hurtEntities;
    private int fallHurtMax;
    private float fallHurtAmount;
    private BlockState block;
    @Override
    public void setHurtEntities(boolean hurtEntities) {
        this.hurtEntities = hurtEntities;
    }

    public FallingIceEntity(World world, double x, double y, double z, BlockState block) {
        super(world, x, y, z, block);
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0F;
        this.block = block;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        if (this.hurtEntities) {
            int i = MathHelper.ceil(fallDistance - 1.0F);
            if (i > 0) {
                List<Entity> list = Lists.newArrayList(this.world.getOtherEntities(this, this.getBoundingBox()));
                DamageSource damageSource = this.DAMAGE_FROM_ICE; //
                Iterator var7 = list.iterator();

                while(var7.hasNext()) {
                    Entity entity = (Entity)var7.next();
                    entity.damage(damageSource, (float)Math.min(MathHelper.floor((float)i * this.fallHurtAmount), this.fallHurtMax));
                }

         //      if (bl && (double)this.random.nextFloat() < 0.05000000074505806D + (double)i * 0.05D) {
                    BlockState blockState = AnvilBlock.getLandingState(this.block);
               /*     if (blockState == null) {
                        this.destroyedOnLanding = true;
                    } else {
                        this.block = blockState;
                    } */
           //     }
            }
        }
        return false;
    }
}
