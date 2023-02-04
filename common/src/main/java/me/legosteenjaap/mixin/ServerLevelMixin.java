package me.legosteenjaap.mixin;

import me.legosteenjaap.DisableNightSkippingExpectPlatform;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.SleepStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/SleepStatus;areEnoughSleeping(I)Z"))
    public boolean stopNightSkipping(SleepStatus sleepStatus, int i) {
        if (!((ServerLevel)(Object)this).getGameRules().getBoolean(DisableNightSkippingExpectPlatform.getEnableNightSkippingGameRuleKey())) return false;
        return sleepStatus.areEnoughSleeping(i);
    }

}
