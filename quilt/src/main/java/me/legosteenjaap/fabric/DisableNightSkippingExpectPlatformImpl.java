package me.legosteenjaap.fabric;

import me.legosteenjaap.quilt.DisableNightSkippingQuilt;
import net.minecraft.world.level.GameRules;

public class DisableNightSkippingExpectPlatformImpl {
    public static GameRules.Key<GameRules.BooleanValue> getEnableNightSkippingGameRuleKey() {
        return DisableNightSkippingQuilt.ENABLE_NIGHT_SKIPPING;
    }
}
