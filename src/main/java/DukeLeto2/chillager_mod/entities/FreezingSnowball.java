package DukeLeto2.chillager_mod.entities;

import DukeLeto2.chillager_mod.ChillagerModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import DukeLeto2.chillager_mod.ChillagerMod;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.dimension.DimensionType;

import static java.lang.Thread.sleep;

public class FreezingSnowball extends SnowballEntity {
    public FreezingSnowball(World world, LivingEntity owner) {
        super(world, owner);
    }

    public FreezingSnowball(EntityType<FreezingSnowball> freezingSnowballEntityType, World world) {
        super((EntityType<? extends SnowballEntity>) freezingSnowballEntityType, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity target = entityHitResult.getEntity();
        float j = target instanceof BlazeEntity ? 6.0F : 0.5F;
        target.damage(DamageSource.thrownProjectile(this, this.getOwner()), j);
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ChillagerMod.FROZEN_EFFECT, 400));
            double y = target.getEyeY();
            BlockPos targetPos = target.getBlockPos();
            targetPos = targetPos.add(0,y-targetPos.getY(),0); //Set blockpos at eye height.
            for (int i = 0; i < 5; ++i) {
                targetPos = targetPos.up();
                if (this.world.getBlockState(targetPos).isOf(Blocks.AIR)) {
                    return;
                }
            }
            if (target.getEntityWorld().canSetBlock(targetPos) && !target.getEntityWorld().getDimension().isUltrawarm()) {
                //targetPos = target.getBlockPos().add(0,5,0);
                this.world.setBlockState(targetPos, ChillagerModBlocks.FALLING_ICE.getDefaultState());
                //this.world.spawnEntity(new FallingIceEntity(this.world, targetPos.getX(),targetPos.getY(), targetPos.getZ(), this.world.getBlockState(targetPos)));
            }
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = ParticleTypes.ITEM_SNOWBALL;
            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
