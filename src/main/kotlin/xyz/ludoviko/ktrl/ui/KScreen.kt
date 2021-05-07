package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.util.cmd.Gamemode
import xyz.ludoviko.ktrl.util.cmd.Time
import xyz.ludoviko.ktrl.util.cmd.Weather


class KScreen : AKScreen(StringTextComponent("Kontrolo")) {

    override fun init() {
        super.init()
        addWeather()
        addTime()
        addGamemode()
    }

    private fun addWeather() {
        addKButton(20, 55, 120, 20, Weather.CLEAR)
        addKButton(150, 55, 120, 20, Weather.RAIN)
        addKButton(280, 55, 120, 20, Weather.THUNDER)
    }

    private fun addTime() {
        addKButton(20, 100, 90, 20, Time.DAY)

        addKButton(120, 100, 90, 20, Time.NOON)

        addKButton(220, 100, 90, 20, Time.NIGHT)

        addKButton(320, 100, 90, 20, Time.MIDNIGHT)

        addKButton(20, 120, 90, 20, Time.ZERO)

        addKButton(120, 120, 90, 20, Time.ADD1, false)

        addKButton(220, 120, 90, 20, Time.ADD2, false)

        addKButton(320, 120, 90, 20, Time.QUERY)
    }

    private fun addGamemode() {
        addKButton(20, 165, 90, 20, Gamemode.CREATIVE)

        addKButton(120, 165, 90, 20, Gamemode.SURVIVAL)

        addKButton(220, 165, 90, 20, Gamemode.ADVENTURE)

        addKButton(320, 165, 90, 20, Gamemode.SPECTATOR)
    }

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
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
        drawString(
            matrixStack, this.font,
            TranslationTextComponent("text.ktrl.gm.label"),
            20, 150, 0xFFFFFF
        )
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}