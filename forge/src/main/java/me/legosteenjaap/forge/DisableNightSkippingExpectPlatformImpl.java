package me.legosteenjaap.forge;

import net.minecraft.world.level.GameRules;

public class DisableNightSkippingExpectPlatformImpl {

    public static GameRules.Key<GameRules.BooleanValue> getEnableNightSkippingGameRuleKey() {
        return DisableNightSkippingForge.ENABLE_NIGHT_SKIPPING;
    }
}
