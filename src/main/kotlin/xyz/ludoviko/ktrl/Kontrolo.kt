package xyz.ludoviko.ktrl

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import xyz.ludoviko.ktrl.key.Key

@Mod(Kontrolo.ID)
object Kontrolo {
    const val ID = "ktrl"

    val LOGGER = LogManager.getLogger()

    init {
        LOGGER.info("Loaded Kontrolo object")

        MOD_BUS.addListener(::onClientLoad)
        FORGE_BUS.addListener(Key::onEvent)
    }

    private fun onClientLoad(event: FMLClientSetupEvent) {
        LOGGER.info("Client started")
        Key
    }

}