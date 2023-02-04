package me.legosteenjaap.fabric;

import me.legosteenjaap.DisableNightSkipping;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public class DisableNightSkippingFabric implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanValue> ENABLE_NIGHT_SKIPPING =
            GameRuleRegistry.register("enableNightSkipping", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

    @Override
    public void onInitialize() {
        DisableNightSkipping.init();
    }
}
