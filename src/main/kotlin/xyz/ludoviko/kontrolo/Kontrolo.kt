package xyz.ludoviko.kontrolo

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Kontrolo.ID)
object Kontrolo {
    const val ID = "ktrl"

    val LOGGER = LogManager.getLogger()

    init {
        LOGGER.info("Loaded Kontrolo object")

        MOD_BUS.addListener(::onClientLoad)
    }

    private fun onClientLoad(event: FMLClientSetupEvent) {
        LOGGER.info("Client started")
    }

}