package xyz.ludoviko.ktrl.util.conf.option

open class OptionType<V, C : Option<V>>(
    private val factory: (String, (String, V, String) -> C) -> Builder<V, C>,
    private val optionFactory: (String, V, String) -> C
) {
    companion object {
        val BOOL = OptionType<Boolean, Option<Boolean>>(::Builder, ::Option)
        val INT = OptionType<Int, Option<Int>>(::Builder, ::Option)
        val STRING = OptionType<String, Option<String>>(::Builder, ::Option)
        val CATEGORY = OptionType(::Builder, ::CategoryOption)
    }

    fun configure(name: String): Builder<V, C> {
        return factory(name, optionFactory)
    }

    class Builder<V, C : Option<V>>(
        private val name: String, private val factory: (String, V, String) -> C
    ) {
        /**
         * The description of the configured option.
         */
        private var description = ""
        private var defaultValue: V? = null

        fun defaultValue(value: V): Builder<V, C> {
            defaultValue = value
            return this
        }

        fun description(desc: String): Builder<V, C> {
            description = desc
            return this
        }

        fun build(): C {
            return factory(name, defaultValue!!, description)
        }
    }
}