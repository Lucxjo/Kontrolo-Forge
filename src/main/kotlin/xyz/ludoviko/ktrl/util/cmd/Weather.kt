package xyz.ludoviko.ktrl.util.cmd

enum class Weather(private val id: Int, private val text: String, private val cmd: String) : Command {
    CLEAR(0, "text.ktrl.weather.clear.label", "/weather clear 15000"),
    RAIN(1, "text.ktrl.weather.rain.label", "/weather rain 15000"),
    THUNDER(2, "text.ktrl.weather.thunder.label", "/weather thunder 15000");

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