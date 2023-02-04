package me.legosteenjaap.mixin;

import me.legosteenjaap.DisableNightSkippingExpectPlatform;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;stopSleepInBed(ZZ)V"))
    private void allowDaySleeping(Player instance, boolean bl, boolean bl2) {
        if (this.level.getGameRules().getBoolean(DisableNightSkippingExpectPlatform.getEnableNightSkippingGameRuleKey())) {
            this.stopSleepInBed(false, true);
        }
    }

    @Shadow
    public void stopSleepInBed(boolean bl, boolean bl2) {

    }

}
