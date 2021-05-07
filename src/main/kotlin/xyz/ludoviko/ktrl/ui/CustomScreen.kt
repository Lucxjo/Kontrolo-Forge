package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.util.text.StringTextComponent

class CustomScreen : AKScreen(StringTextComponent("Kontrolo")) {
    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}