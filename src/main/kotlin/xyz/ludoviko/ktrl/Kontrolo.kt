package xyz.ludoviko.ktrl

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screen.Screen
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.fml.ExtensionPoint
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerConfig
import xyz.ludoviko.ktrl.key.Key
import xyz.ludoviko.ktrl.ui.ConfigGUI
import xyz.ludoviko.ktrl.util.conf.Holder
import java.util.function.BiFunction


@Mod(Kontrolo.ID)
object Kontrolo {
    const val ID = "ktrl"

    val LOGGER = LogManager.getLogger()

    init {
        LOGGER.info("Loaded Kontrolo object")

        MOD_BUS.addListener(::onClientLoad)
        MOD_BUS.addListener(Holder::sync)
        FORGE_BUS.addListener(Key::onEvent)

        ModLoadingContext.get().registerExtensionPoint(
            ExtensionPoint.CONFIGGUIFACTORY
        ) { BiFunction { mc: Minecraft?, screen: Screen? -> ConfigGUI() } }

        val specPair = ForgeConfigSpec.Builder().configure(Holder::configure)
        registerConfig(ModConfig.Type.CLIENT, specPair.right, "kontrolo.toml")
    }

    private fun onClientLoad(event: FMLClientSetupEvent) {
        LOGGER.info("Client started")
        Key
    }

}