package me.ivan.gatewayer.mixin;

import me.ivan.gatewayer.Gatewayer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "renderWorld(FJLnet/minecraft/client/util/math/MatrixStack;)V", at = @At(value = "INVOKE_STRING", target = "Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", args = {
            "ldc=hand" }))

    private void onRenderCenterLast(float partialTicks, final long nanoTime, MatrixStack stack, CallbackInfo info) {
        Gatewayer.getInstance().renderLines(stack, partialTicks);
    }
}
