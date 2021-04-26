package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.screen.Screen
import net.minecraft.util.text.TranslationTextComponent

class ConfigGUI : Screen(TranslationTextComponent("text.ktrl.title")) {
    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 8, 0xFFFFFF)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}