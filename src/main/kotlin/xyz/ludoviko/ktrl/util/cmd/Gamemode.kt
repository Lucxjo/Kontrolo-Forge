package xyz.ludoviko.ktrl.util.cmd

enum class Gamemode(private val id: Int, private val translationKey: String, private val cmd: String) : Command {
    CREATIVE(0, "text.ktrl.gm.creative.label", "/gamemode creative"),
    SURVIVAL(1, "text.ktrl.gm.survival.label", "/gamemode survival"),
    ADVENTURE(2, "text.ktrl.gm.adventure.label", "/gamemode adventure"),
    SPECTATOR(3, "text.ktrl.gm.spectator.label", "/gamemode spectator");

    fun byId(id: Int): Gamemode {
        for (gm in Gamemode.values()) {
            if (gm.id == id) return gm
        }
        return SURVIVAL
    }

    override fun id(): Int {
        return id
    }

    override fun text(): String {
        return translationKey
    }

    override fun command(): String {
        return cmd
    }
}