package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.button.Button
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.ui.widget.KButton


class KScreen : Screen(StringTextComponent("Kontrolo")) {
    /** Width of a button  */
    private val BUTTON_WIDTH = 200

    /** Height of a button  */
    private val BUTTON_HEIGHT = 20

    /** Distance from bottom of the screen to the "Done" button's top  */
    private val DONE_BUTTON_TOP_OFFSET = 26

    override fun init() {
        super.init()

        addWeather()

        addButton(KButton(
            (width - BUTTON_WIDTH) / 2,
            height - DONE_BUTTON_TOP_OFFSET,
            BUTTON_WIDTH, BUTTON_HEIGHT,  // Text shown on the button
            TranslationTextComponent("gui.done")
        )  // Action performed when the button is pressed
        { button: Button? -> onClose() })
    }

    private fun addWeather() {
        addButton(KButton(
            20, 55, 120, 20, TranslationTextComponent("text.ktrl.weather.clear.label")
        ) {
            Minecraft.getInstance().player?.chat("/weather clear 15000")
        })
        addButton(KButton(
            150, 55, 120, 20, TranslationTextComponent("text.ktrl.weather.rain.label")
        ) {
            Minecraft.getInstance().player?.chat("/weather rain 15000")
        })
        addButton(KButton(
            280, 55, 120, 20, TranslationTextComponent("text.ktrl.weather.thunder.label")
        ) {
            Minecraft.getInstance().player?.chat("/weather thunder 15000")
        })
    }

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 20, 0xFFFFFF)
        drawString(
            matrixStack, this.font,
            TranslationTextComponent("text.ktrl.weather.label"),
            20, 40, 0xFFFFFF
        )
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}