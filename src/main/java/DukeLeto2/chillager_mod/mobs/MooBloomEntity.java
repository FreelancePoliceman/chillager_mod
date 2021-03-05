package DukeLeto2.chillager_mod.mobs;

/*
public class MooBloomEntity extends CowEntity implements Shearable {

    public MooBloomEntity(EntityType<? extends MooBloomEntity> entityType, World world) {
        super(entityType, world);
    }

    private static int tickCount = 0;

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            return;
        }
        if (tickCount < 2400) {
            ++tickCount;
        }
        else {
            Random rand = new Random();
            BlockState blockState;
            tickCount = 0;

            if (rand.nextBoolean()) {
               // blockState = BlocksEveryoneWon.BUTTERCUP_BLOCK.getDefaultState();
                blockState = Blocks.DANDELION.getDefaultState();
                if (this.world.getBlockState(this.getBlockPos()).isAir() && blockState.canPlaceAt(this.world, this.getBlockPos())) {
                    this.world.setBlockState(this.getBlockPos(), blockState);
                }
            }
            else {
               List flowerList = this.world.getBiome(this.getBlockPos()).getGenerationSettings().getFlowerFeatures();
                if (flowerList.isEmpty()) {
                    return;
              }
    //Magic.
                ConfiguredFeature<?, ?> configuredFeature = (ConfiguredFeature)flowerList.get(0);
               /* if (! this.world.isClient()) {
                    System.out.println("List is size " + flowerList.size());
                }   // flowerList is size 1 -- why?
                FlowerFeature flowerFeature = (FlowerFeature)configuredFeature.feature;
                blockState = flowerFeature.getFlowerState(rand, this.getBlockPos(), configuredFeature.getConfig());
                if (this.world.getBlockState(this.getBlockPos()).isAir() && blockState.canPlaceAt(this.world, this.getBlockPos())) {
                    this.world.setBlockState(this.getBlockPos(), blockState);
                }
            }
        }

    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemInHand = player.getStackInHand(hand);
        if (itemInHand.getItem() == Items.SHEARS && this.isShearable()) {
            this.sheared(SoundCategory.PLAYERS);
            if (!this.world.isClient) {
                itemInHand.damage(1, player, (playerEntity) -> {
                    playerEntity.sendToolBreakStatus(hand);
                });
            }
            return ActionResult.success(this.world.isClient);
        }
        else if (itemInHand.getItem() == Items.BUCKET && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.method_30012(itemInHand, player, ItemsEveryoneWon.BUTTERMILK_BUCKET.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.world.isClient);
        }
        else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public void sheared(SoundCategory shearedSoundCategory) {
        this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        if (!this.world.isClient()) {
            ((ServerWorld)this.world).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.remove();
            CowEntity cowEntity = (CowEntity)EntityType.COW.create(this.world);
            cowEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, this.pitch);
            cowEntity.setHealth(this.getHealth());
            cowEntity.bodyYaw = this.bodyYaw;
            if (this.hasCustomName()) {
                cowEntity.setCustomName(this.getCustomName());
                cowEntity.setCustomNameVisible(this.isCustomNameVisible());
            }

            if (this.isPersistent()) {
                cowEntity.setPersistent();
            }

            cowEntity.setInvulnerable(this.isInvulnerable());
            this.world.spawnEntity(cowEntity);

            for(int i = 0; i < 5; ++i) {
                this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getBodyY(1.0D), this.getZ(), new ItemStack(Blocks.DANDELION)));
            }
        }
    }

    @Override
    public CowEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
     //   return ChillagerModEntities.MOOBLOOM.create(serverWorld);
    }
    @Override
    public boolean isShearable() {
        return this.isAlive() && !this.isBaby();
    }
} */
