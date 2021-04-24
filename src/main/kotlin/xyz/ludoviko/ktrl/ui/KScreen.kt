package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.button.Button
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.ui.widget.KButton
import xyz.ludoviko.ktrl.util.Command
import xyz.ludoviko.ktrl.util.Gamemode
import xyz.ludoviko.ktrl.util.Time
import xyz.ludoviko.ktrl.util.Weather


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
        addTime()
        addGamemode()

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
            20, 55, 120, 20, TranslationTextComponent(Weather.CLEAR.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/weather clear 15000")
            onClose()
        })
        addButton(KButton(
            150, 55, 120, 20, TranslationTextComponent(Weather.RAIN.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/weather rain 15000")
            onClose()
        })
        addButton(KButton(
            280, 55, 120, 20, TranslationTextComponent(Weather.THUNDER.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/weather thunder 15000")
            onClose()
        })
    }

    private fun addTime() {
        addButton(KButton(
            20, 100, 90, 20, TranslationTextComponent(Time.DAY.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/time set day")
            onClose()
        })

        addButton(KButton(
            120, 100, 90, 20, TranslationTextComponent(Time.NOON.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/time set noon")
            onClose()
        })

        addButton(KButton(
            220, 100, 90, 20, TranslationTextComponent(Time.NIGHT.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/time set night")
            onClose()
        })

        addButton(KButton(
            320, 100, 90, 20, TranslationTextComponent(Time.MIDNIGHT.translationKey())
        ) {
            Minecraft.getInstance().player?.chat("/time set midnight")
            onClose()
        })

        addButton(KButton(
            20, 120, 90, 20, TranslationTextComponent("text.ktrl.time.zero.label")
        ) {
            Minecraft.getInstance().player?.chat("/time set 0")
            onClose()
        })

        addButton(KButton(
            120, 120, 90, 20, StringTextComponent("+ 1000")
        ) {
            Minecraft.getInstance().player?.chat("/time add 1000")
            onClose()
        })

        addButton(KButton(
            220, 120, 90, 20, StringTextComponent("+ 10000")
        ) {
            Minecraft.getInstance().player?.chat("/time add 10000")
            onClose()
        })

        addButton(KButton(
            320, 120, 90, 20, TranslationTextComponent("text.ktrl.time.button")
        ) {
            Minecraft.getInstance().player?.chat("/time query gametime")
            onClose()
        })
    }

    private fun addGamemode() {
        addKButton(20, 165, 90, 20, Gamemode.CREATIVE)

        addKButton(120, 165, 90, 20, Gamemode.SURVIVAL)

        addKButton(220, 165, 90, 20, Gamemode.ADVENTURE)

        addKButton(320, 165, 90, 20, Gamemode.SPECTATOR)
    }

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 20, 0xFFFFFF)
        drawString(
            matrixStack, this.font,
            TranslationTextComponent("text.ktrl.weather.label"),
            20, 40, 0xFFFFFF
        )
        drawString(
            matrixStack, this.font,
            TranslationTextComponent("text.ktrl.time.label"),
            20, 85, 0xFFFFFF
        )
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }

    fun addKButton(xPos: Int, yPos: Int, width: Int, height: Int, enum: Command) {
        addButton(KButton(
            xPos, yPos, width, height, TranslationTextComponent(enum.translationKey())
        ) {
            Minecraft.getInstance().player?.chat(enum.command())
            onClose()
        })
    }
}