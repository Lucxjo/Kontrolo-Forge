package xyz.ludoviko.ktrl.key

import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import org.lwjgl.glfw.GLFW

object Key {
    lateinit var keys: Array<KeyBinding>

    init {
        keys[0] = KeyBinding("key.ktrl.gui", GLFW.GLFW_KEY_K, "category.ktrl.gui")

        for (i in keys.indices) {
            ClientRegistry.registerKeyBinding(keys[i])
        }
    }

    fun onEvent(event: InputEvent.KeyInputEvent) {
        //if (keys[0].isDown) Minecraft.getInstance().setScreen()
    }
}