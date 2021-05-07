package xyz.ludoviko.ktrl.key

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import org.lwjgl.glfw.GLFW
import xyz.ludoviko.ktrl.ui.CustomScreen
import xyz.ludoviko.ktrl.ui.KScreen

object Key {
    var keys = arrayOf(
        KeyBinding("key.ktrl.gui", GLFW.GLFW_KEY_K, "category.ktrl.gui"),
        KeyBinding("key.ktrl.gui.custom", GLFW.GLFW_KEY_UNKNOWN, "category.ktrl.gui")
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