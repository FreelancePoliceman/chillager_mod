package DukeLeto2.chillager_mod.mobs;

import DukeLeto2.chillager_mod.ChillagerModBlocks;
import DukeLeto2.chillager_mod.ChillagerMod;
import DukeLeto2.chillager_mod.entities.FallingIceEntity;
import DukeLeto2.chillager_mod.entities.FreezingSnowball;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class ChillagerEntity extends HostileEntity implements RangedAttackMob {
    public static boolean vanishinsunlight;
    public static boolean vanishinheat;
    public static boolean harmotherchillagers;
    public static boolean attackwithsnowballs;
    private double time_when_last_attacked = 0D;
    public ChillagerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 15.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 15.0F));
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.7D));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.50D, 20, 15.0F));
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.vanishinsunlight){
            if (this.isAffectedByDaylight() && !this.hasCustomName())
                this.remove();
        }
        if (this.vanishinheat) {
            if (this.world.getBiome(this.getBlockPos()).getTemperature() >= 0.5F && !this.hasCustomName()) {
                this.remove();
            }
        }
      /*  if (this.isAffectedByDaylight() || this.world.getBiome(this.getBlockPos()).getTemperature() >= 0.5F ) {
            if (!this.hasCustomName()) {
                this.remove();
            }
        } */
    }

    //Copied from SnowGolemEntity.class
    @Override
    public void attack(LivingEntity target, float pullProgress) {
        if (System.currentTimeMillis() < this.time_when_last_attacked + 2200 /* Bit over 2 seconds */ )
            return;
        if (!this.harmotherchillagers) {
            if (target instanceof ChillagerEntity)
                return;
        }
        if (target.hasStatusEffect(ChillagerMod.FROZEN_EFFECT) || attackwithsnowballs == false) {
            double y = target.getEyeY();
            BlockPos targetPos = target.getBlockPos();
            targetPos = targetPos.add(0,y-targetPos.getY(),0); //Set blockpos at eye height.

            for (int i = 0; i < 10; ++i) {
                targetPos = targetPos.up();
                if (!this.world.getBlockState(targetPos).isOf(Blocks.AIR)) {
                    if (i <= 2) {
                        if (attackwithsnowballs == false)
                            return;
                        shootSnowball(target);
                        this.time_when_last_attacked = System.currentTimeMillis();
                        return;
                    }
                    else
                        break; //Allow the chillager to place ice wherever he can, though not the max height.
                }
            }
            if (target.getEntityWorld().canSetBlock(targetPos)) {
                this.world.setBlockState(targetPos, ChillagerModBlocks.FALLING_ICE.getDefaultState());
                this.time_when_last_attacked = System.currentTimeMillis();
                //this.world.spawnEntity(new FallingIceEntity());
            }
        }
        else {
            shootSnowball(target);
            this.time_when_last_attacked = System.currentTimeMillis();
        }
    }

    private void shootSnowball(LivingEntity target) {
        FreezingSnowball freezingSnowball = new FreezingSnowball(this.world, this);
        double d = target.getEyeY() - 1.100000023841858D;
        double e = target.getX() - this.getX();
        double f = d - freezingSnowball.getY();
        double g = target.getZ() - this.getZ();
        float h = MathHelper.sqrt(e * e + g * g) * 0.2F;
        freezingSnowball.setVelocity(e, f + (double) h, g, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(freezingSnowball);
    }

    public static DefaultAttributeContainer.Builder createChillagerAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 18.0D).add(EntityAttributes.GENERIC_MAX_HEALTH, 32.0D);
    }
    public static boolean canSpawnChillagerInDark(EntityType<? extends ChillagerEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) <= 8 && canSpawnIgnoreLightLevel(type, world, spawnReason, pos, random)) {
            return true;
        }
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EVOKER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_EVOKER_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_EVOKER_HURT;
    }
}
