package xyz.ludoviko.ktrl.util

enum class Weather(private val id: Int, private val translationKey: String) {
    CLEAR(0, "text.ktrl.weather.clear.label"),
    RAIN(1, "text.ktrl.weather.rain.label"),
    THUNDER(2, "text.ktrl.weather.thunder.label");

    fun byId(id: Int): Weather {
        for (weather in values()) {
            if (weather.id == id) return weather
        }
        return CLEAR
    }

    fun id(): Int {
        return id
    }

    fun translationKey(): String {
        return translationKey
    }
}