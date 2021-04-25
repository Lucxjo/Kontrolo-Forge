package xyz.ludoviko.ktrl.util.cmd

import xyz.ludoviko.ktrl.util.conf.Config

enum class Time(private val id: Int, private val text: String, private val cmd: String) : Command {
    DAY(0, "text.ktrl.time.day.label", "/time set day"),
    NOON(1, "text.ktrl.time.noon.label", "/time set noon"),
    NIGHT(2, "text.ktrl.time.night.label", "/time set night"),
    MIDNIGHT(3, "text.ktrl.time.mn.label", "/time set midnight"),
    ZERO(4, "text.ktrl.time.zero.label", "/time set 0"),
    ADD1(5, "+ ${Config.timeAdd1.value}", "/time add ${Config.timeAdd1.value}"),
    ADD2(6, "+ ${Config.timeAdd2.value}", "/time add ${Config.timeAdd2.value}"),
    QUERY(-1, "text.ktrl.time.button", "/time query gametime");

    fun byId(id: Int): Time {
        for (time in Time.values()) {
            if (time.id == id) return time
        }
        return DAY
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