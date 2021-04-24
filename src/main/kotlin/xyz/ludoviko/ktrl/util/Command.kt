package xyz.ludoviko.ktrl.util

interface Command {

    fun id(): Int

    fun text(): String

    fun command(): String
}