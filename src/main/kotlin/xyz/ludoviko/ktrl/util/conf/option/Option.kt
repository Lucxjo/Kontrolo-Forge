package xyz.ludoviko.ktrl.util.conf.option

import com.electronwill.nightconfig.core.CommentedConfig
import net.minecraftforge.common.ForgeConfigSpec
import xyz.ludoviko.ktrl.Kontrolo

open class Option<V>(val name: String, private val default: V, val desc: String) {
    var value: V = default
    val translation: String
        get() = "config.${Kontrolo.ID}.${name}"

    open fun sync(data: CommentedConfig, parentName: String) {
        this.value = data.get("$parentName.$name")
    }

    open fun getOptions(): Array<Option<*>> {
        return arrayOf(this)
    }

    open fun addToConfig(builder: ForgeConfigSpec.Builder) {
        builder
            .comment(desc)
            .translation(translation)
            .define(name, default)
    }
}