package xyz.ludoviko.ktrl.util.conf

import xyz.ludoviko.ktrl.util.conf.option.OptionType

object Config {
    val time = OptionType.CATEGORY
        .configure("time")
        .description("Options for time controls")
        .defaultValue(Unit)
        .build()

    val weather = OptionType.CATEGORY
        .configure("weather")
        .description("Options for weather controls")
        .defaultValue(Unit)
        .build()

    val timeAdd1 = OptionType.INT
        .configure("timeAdd1")
        .description("How much time (ticks) the first add button should increment")
        .defaultValue(1000)
        .build()
    val timeAdd2 = OptionType.INT
        .configure("timeAdd2")
        .description("How much time (ticks) the second add button should increment")
        .defaultValue(10000)
        .build()

    val weatherDelay = OptionType.INT
        .configure("delay")
        .description("How much time (ticks) the weather condition should last for")
        .defaultValue(1500)
        .build()

    private var setup = false

    fun setup() {
        if (!setup) {
            time.add(timeAdd1)
            time.add(timeAdd2)
            weather.add(weatherDelay)

            setup = true
        }
    }
}