package xyz.ludoviko.ktrl.key

import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.fmlclient.registry.ClientRegistry
import org.lwjgl.glfw.GLFW
import xyz.ludoviko.ktrl.ui.CustomScreen
import xyz.ludoviko.ktrl.ui.KScreen

object Key {
    var keys = arrayOf(
        KeyMapping("key.ktrl.gui", GLFW.GLFW_KEY_K, "category.ktrl.gui"),
        KeyMapping("key.ktrl.gui.custom", GLFW.GLFW_KEY_UNKNOWN, "category.ktrl.gui")
    )

    init {
        for (i in keys.indices) {
            ClientRegistry.registerKeyBinding(keys[i])
        }
    }

    fun onEvent(event: InputEvent.KeyInputEvent) {
        if (keys[0].isDown) Minecraft.getInstance().setScreen(KScreen())
        if (keys[1].isDown) Minecraft.getInstance().setScreen(CustomScreen())
    }
}
