package xyz.ludoviko.ktrl.util.conf

import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.fml.config.ModConfig

object Holder {
    fun configure(builder: ForgeConfigSpec.Builder) {
        Config.setup()
        Config.time.addToConfig(builder)
        Config.weather.addToConfig(builder)
        Config.custom.addToConfig(builder)
    }

    fun sync(event: ModConfig.ModConfigEvent) {
        val data = event.config.configData

        Config.time.sync(data, "")
        Config.weather.sync(data, "")
        Config.custom.sync(data, "")
    }
}