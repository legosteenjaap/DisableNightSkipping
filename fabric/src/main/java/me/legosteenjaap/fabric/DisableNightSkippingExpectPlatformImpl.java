package me.legosteenjaap.fabric;

import net.minecraft.world.level.GameRules;

public class DisableNightSkippingExpectPlatformImpl {

    public static GameRules.Key<GameRules.BooleanValue> getEnableNightSkippingGameRuleKey() {
        return DisableNightSkippingFabric.ENABLE_NIGHT_SKIPPING;
    }
}
