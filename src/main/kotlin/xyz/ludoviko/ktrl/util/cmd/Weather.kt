package xyz.ludoviko.ktrl.util.cmd

import xyz.ludoviko.ktrl.util.conf.Config

enum class Weather(private val id: Int, private val text: String, private val cmd: String) : Command {
    CLEAR(0, "text.ktrl.weather.clear.label", "/weather clear ${Config.weatherDelay.value}"),
    RAIN(1, "text.ktrl.weather.rain.label", "/weather rain ${Config.weatherDelay.value}"),
    THUNDER(2, "text.ktrl.weather.thunder.label", "/weather thunder ${Config.weatherDelay.value}");

    fun byId(id: Int): Weather {
        for (weather in values()) {
            if (weather.id == id) return weather
        }
        return CLEAR
    }

    override fun id(): Int {
        return id
    }

    override fun text(): String {
        return text
    }

    override fun command(): String {
        return cmd
    }
}