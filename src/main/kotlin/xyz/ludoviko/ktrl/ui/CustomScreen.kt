package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.util.text.StringTextComponent
import xyz.ludoviko.ktrl.util.conf.Config

class CustomScreen : AKScreen(StringTextComponent("Kontrolo")) {

    override fun init() {
        super.init()

        if (Config.isButton0Active.value)
            addKButton(120, 100, 90, 20, Config.button0Title.value, Config.button0Cmd.value)

        if (Config.isButton1Active.value)
            addKButton(220, 100, 90, 20, Config.button1Title.value, Config.button1Cmd.value)

        if (Config.isButton2Active.value)
            addKButton(120, 130, 90, 20, Config.button2Title.value, Config.button2Cmd.value)

        if (Config.isButton3Active.value)
            addKButton(220, 130, 90, 20, Config.button3Title.value, Config.button3Cmd.value)

        if (Config.isButton4Active.value)
            addKButton(120, 160, 90, 20, Config.button4Title.value, Config.button4Cmd.value)

        if (Config.isButton5Active.value)
            addKButton(220, 160, 90, 20, Config.button5Title.value, Config.button5Cmd.value)
    }

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }
}