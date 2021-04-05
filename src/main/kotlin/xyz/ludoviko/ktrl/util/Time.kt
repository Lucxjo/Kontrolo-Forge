package xyz.ludoviko.ktrl.util

enum class Time(private val id: Int, private val translationKey: String) {
    DAY(0, "text.ktrl.time.day.label"),
    NOON(1, "text.ktrl.time.noon.label"),
    NIGHT(2, "text.ktrl.time.night.label"),
    MIDNIGHT(3, "text.ktrl.time.mn.label");

    fun byId(id: Int): Time {
        for (time in Time.values()) {
            if (time.id == id) return time
        }
        return DAY
    }

    fun id(): Int {
        return id
    }

    fun translationKey(): String {
        return translationKey
    }
}