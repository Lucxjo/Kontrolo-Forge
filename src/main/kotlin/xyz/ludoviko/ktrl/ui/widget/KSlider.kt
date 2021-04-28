package xyz.ludoviko.ktrl.ui.widget

import net.minecraft.client.GameSettings
import net.minecraft.client.settings.SliderPercentageOption
import net.minecraft.util.text.ITextComponent
import java.util.function.BiConsumer
import java.util.function.BiFunction
import java.util.function.Function

class KSlider(
    translationKey: String,
    minValue: Double,
    maxValue: Double,
    stepSize: Float,
    getter: Function<GameSettings, Double>,
    setter: BiConsumer<GameSettings, Double>,
    getDisplayString: BiFunction<GameSettings, SliderPercentageOption, ITextComponent>
) : SliderPercentageOption(translationKey, minValue, maxValue, stepSize, getter, setter, getDisplayString)