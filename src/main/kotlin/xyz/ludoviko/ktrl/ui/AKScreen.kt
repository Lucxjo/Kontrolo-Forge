package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screen.Screen
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.ui.widget.KButton
import xyz.ludoviko.ktrl.util.cmd.Command

abstract class AKScreen(title: ITextComponent) : Screen(title) {
    fun addKButton(xPos: Int, yPos: Int, width: Int, height: Int, enum: Command, translatable: Boolean = true) {
        addButton(KButton(
            xPos, yPos, width, height, if (translatable) {
                TranslationTextComponent(enum.text())
            } else {
                StringTextComponent(enum.text())
            }
        ) {
            Minecraft.getInstance().player?.chat(enum.command())
            onClose()
        })
    }

    // Helper function to ensure correct namings are used in function parameters
    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 20, 0xFFFFFF)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}