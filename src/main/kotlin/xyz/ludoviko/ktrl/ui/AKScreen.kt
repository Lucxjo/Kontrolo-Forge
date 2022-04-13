package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TextComponent
import net.minecraft.network.chat.TranslatableComponent
import xyz.ludoviko.ktrl.ui.widget.KButton
import xyz.ludoviko.ktrl.util.cmd.Command

abstract class AKScreen(title: Component) : Screen(title) {
    fun addKButton(xPos: Int, yPos: Int, width: Int, height: Int, enum: Command, translatable: Boolean = true) {
        addButton(
            KButton(
                xPos, yPos, width, height, if (translatable) {
                    TranslatableComponent(enum.text())
                } else {
                    TextComponent(enum.text())
                }
            ) {
                Minecraft.getInstance().player?.chat(enum.command())
                onClose()
        })
    }

    fun addKButton(xPos: Int, yPos: Int, width: Int, height: Int, title: String, cmd: String) {
        addButton(KButton(
            xPos, yPos, width, height, TextComponent(title)
        ) {
            Minecraft.getInstance().player?.chat(cmd)
            onClose()
        })
    }

    // Helper function to ensure correct namings are used in function parameters
    override fun render(matrixStack: PoseStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 20, 0xFFFFFF)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}