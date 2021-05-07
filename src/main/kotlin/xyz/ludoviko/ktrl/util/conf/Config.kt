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

    val custom = OptionType.CATEGORY
        .configure("custom")
        .description("Option for custom shortcuts screen.")
        .defaultValue(Unit)
        .build()

    val button0 = OptionType.CATEGORY
        .configure("button0")
        .description("Options for first button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton0Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(true)
        .build()
    val button0Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 0")
        .build()
    val button0Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    val button1 = OptionType.CATEGORY
        .configure("button1")
        .description("Options for second button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton1Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(false)
        .build()
    val button1Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 1")
        .build()
    val button1Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    val button2 = OptionType.CATEGORY
        .configure("button2")
        .description("Options for third button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton2Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(false)
        .build()
    val button2Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 2")
        .build()
    val button2Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    val button3 = OptionType.CATEGORY
        .configure("button3")
        .description("Options for fourth button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton3Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(false)
        .build()
    val button3Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 3")
        .build()
    val button3Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    val button4 = OptionType.CATEGORY
        .configure("button4")
        .description("Options for fifth button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton4Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(false)
        .build()
    val button4Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 4")
        .build()
    val button4Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    val button5 = OptionType.CATEGORY
        .configure("button5")
        .description("Options for sixth button in menu.")
        .defaultValue(Unit)
        .build()
    val isButton5Active = OptionType.BOOL
        .configure("isActive")
        .description("Should the button be shown in the menu?")
        .defaultValue(false)
        .build()
    val button5Title = OptionType.STRING
        .configure("title")
        .description("What should be shown on the button.")
        .defaultValue("Button 5")
        .build()
    val button5Cmd = OptionType.STRING
        .configure("command")
        .description("What command should be executed (include /).")
        .defaultValue("/say this is a command")
        .build()

    private var setup = false

    fun setup() {
        if (!setup) {
            time.add(timeAdd1)
            time.add(timeAdd2)
            weather.add(weatherDelay)

            custom.add(button0)
            button0.add(isButton0Active)
            button0.add(button0Title)
            button0.add(button0Cmd)

            custom.add(button1)
            button1.add(isButton1Active)
            button1.add(button1Title)
            button1.add(button1Cmd)

            custom.add(button2)
            button2.add(isButton2Active)
            button2.add(button2Title)
            button2.add(button2Cmd)

            custom.add(button3)
            button3.add(isButton3Active)
            button3.add(button3Title)
            button3.add(button3Cmd)

            custom.add(button4)
            button4.add(isButton4Active)
            button4.add(button4Title)
            button4.add(button4Cmd)

            custom.add(button5)
            button5.add(isButton5Active)
            button5.add(button5Title)
            button5.add(button5Cmd)

            setup = true
        }
    }
}