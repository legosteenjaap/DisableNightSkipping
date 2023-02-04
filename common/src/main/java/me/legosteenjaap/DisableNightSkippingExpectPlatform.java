package me.legosteenjaap;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.GameRules;

public class DisableNightSkippingExpectPlatform {

    @ExpectPlatform
    public static GameRules.Key<GameRules.BooleanValue> getEnableNightSkippingGameRuleKey() {
        throw new AssertionError();
    }
}
