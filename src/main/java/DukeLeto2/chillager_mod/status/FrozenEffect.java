package DukeLeto2.chillager_mod.status;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class FrozenEffect extends StatusEffect {
    public FrozenEffect() {
        super(StatusEffectType.HARMFUL, 0x34d0eb);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,"a3c0a246-547c-4e6f-949c-f9bb24b78842", -0.15000000596046448D*4.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL );
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "a3c0a246-547c-4e6f-949c-f9bb24b78843", 0.10000000149011612D*3.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    @Override
    public boolean canApplyUpdateEffect (int duration, int amplifier) {
        return true;
    }
/* //None of these functions seems to do anything.
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity && entity.getEntityWorld().getServer().getSaveProperties().getGameMode() != GameMode.CREATIVE ) {
            ((PlayerEntity) (entity)).abilities.allowModifyWorld = false;
        }
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (entity instanceof PlayerEntity && (entity.getEntityWorld().getServer().getSaveProperties().getGameMode() == GameMode.SURVIVAL || entity.getEntityWorld().getServer().getSaveProperties().getGameMode() == GameMode.CREATIVE )) {
                ((PlayerEntity) (entity)).abilities.allowModifyWorld = true;

        }
    } */
}
