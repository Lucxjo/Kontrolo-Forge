package xyz.ludoviko.ktrl.ui

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.button.Button
import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent
import xyz.ludoviko.ktrl.ui.widget.KButton


class KScreen : Screen(StringTextComponent("")) {
    /** Width of a button  */
    private val BUTTON_WIDTH = 200

    /** Height of a button  */
    private val BUTTON_HEIGHT = 20

    /** Distance from bottom of the screen to the "Done" button's top  */
    private val DONE_BUTTON_TOP_OFFSET = 26

    override fun init() {
        super.init()
        addButton(KButton(
            (width - BUTTON_WIDTH) / 2,
            height - DONE_BUTTON_TOP_OFFSET,
            BUTTON_WIDTH, BUTTON_HEIGHT,  // Text shown on the button
            TranslationTextComponent("gui.done")
        )  // Action performed when the button is pressed
        { button: Button? -> onClose() })
    }
}