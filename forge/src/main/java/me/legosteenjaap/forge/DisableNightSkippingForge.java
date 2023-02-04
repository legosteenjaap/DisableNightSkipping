package me.legosteenjaap.forge;

import me.legosteenjaap.DisableNightSkipping;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

@Mod(DisableNightSkipping.MOD_ID)
public class DisableNightSkippingForge {
    public static GameRules.Key<GameRules.BooleanValue> ENABLE_NIGHT_SKIPPING;

    public DisableNightSkippingForge() {
        ENABLE_NIGHT_SKIPPING = GameRules.register("enableNightSkipping", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
    }
}
