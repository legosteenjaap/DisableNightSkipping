package me.legosteenjaap.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Either;
import me.legosteenjaap.DisableNightSkippingExpectPlatform;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player{

    @Shadow protected abstract ItemCooldowns createItemCooldowns();

    public ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable ProfilePublicKey profilePublicKey) {
        super(level, blockPos, f, gameProfile, profilePublicKey);
    }



    @Inject(method = "startSleepInBed", at = @At("RETURN"), cancellable = true)
    private void startSleepInBed(BlockPos blockPos, CallbackInfoReturnable<Either<Player.BedSleepingProblem, Unit>> cir) {
        if (!this.level.getGameRules().getBoolean(DisableNightSkippingExpectPlatform.getEnableNightSkippingGameRuleKey())) {
            if (cir.getReturnValue().left().isPresent()) {
                if (cir.getReturnValue().left().get().equals(BedSleepingProblem.NOT_POSSIBLE_NOW) || cir.getReturnValue().left().get().equals(BedSleepingProblem.NOT_SAFE)) {
                    Either<Player.BedSleepingProblem, Unit> either = super.startSleepInBed(blockPos).ifRight(unit -> {
                        this.awardStat(Stats.SLEEP_IN_BED);
                        CriteriaTriggers.SLEPT_IN_BED.trigger((ServerPlayer)(Object)this);
                    });
                    ((ServerLevel)this.level).updateSleepingPlayerList();
                    cir.setReturnValue(either);
                }
            }
        }
    }

}
