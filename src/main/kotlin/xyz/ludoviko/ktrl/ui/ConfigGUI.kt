package xyz.ludoviko.ktrl.ui

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.Widget
import net.minecraft.client.gui.widget.list.OptionsRowList
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.ui.widget.KButton


class ConfigGUI : Screen(TranslationTextComponent("text.ktrl.title")) {
    private val OPTIONS_LIST_TOP_HEIGHT = 24 // Distance from top of the screen to the options row list's top
    private val OPTIONS_LIST_BOTTOM_OFFSET = 32 // Distance from bottom of the screen to the options row list's bottom
    private val OPTIONS_LIST_ITEM_HEIGHT = 25 // Height of each item in the options row list
    private val BUTTON_WIDTH = 200 // Width of a button
    private val BUTTON_HEIGHT = 20 // Height of a button
    private val DONE_BUTTON_TOP_OFFSET = 26 // Distance from bottom of the screen to the "Done" button's top

    private var optionsRowList: OptionsRowList? = null

    override fun render(matrixStack: MatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.renderBackground(matrixStack)
        this.optionsRowList?.render(matrixStack, mouseX, mouseY, partialTicks)
        drawCenteredString(matrixStack, this.font, this.title.string, this.width / 2, 8, 0xFFFFFF)
        super.render(matrixStack, mouseX, mouseY, partialTicks)
    }

    override fun init() {
        super.init()
        optionsRowList = OptionsRowList(
            minecraft!!, width, height,
            OPTIONS_LIST_TOP_HEIGHT,
            height - OPTIONS_LIST_BOTTOM_OFFSET,
            OPTIONS_LIST_ITEM_HEIGHT
        )

        // Add the options row list as this screen's child
        // If this is not done, users cannot click on items in the list

        // Add the options row list as this screen's child
        // If this is not done, users cannot click on items in the list
        children.add(optionsRowList)

        // Add the "Done" button
        addButton<Widget>(KButton(
            (width - BUTTON_WIDTH) / 2,
            height - DONE_BUTTON_TOP_OFFSET,
            BUTTON_WIDTH, BUTTON_HEIGHT,  // Text shown on the button
            TranslationTextComponent("gui.done")
        )  // Action performed when the button is pressed
        { button -> onClose() })
    }
}