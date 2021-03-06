package xyz.ludoviko.ktrl.ui.widget

import net.minecraft.client.gui.widget.button.Button
import net.minecraft.util.text.ITextComponent

class KButton(
    xPos: Int,
    yPos: Int,
    width: Int,
    height: Int,
    text: ITextComponent,
    tooltip: Button.ITooltip = NO_TOOLTIP,
    action: Button.IPressable
) : Button(xPos, yPos, width, height, text, action, tooltip)