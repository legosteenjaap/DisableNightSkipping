package me.legosteenjaap.quilt;

import me.legosteenjaap.DisableNightSkipping;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class DisableNightSkippingQuilt implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanValue> ENABLE_NIGHT_SKIPPING =
            GameRuleRegistry.register("enableNightSkipping", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

    @Override
    public void onInitialize(ModContainer mod) {
        DisableNightSkipping.init();
    }
}
