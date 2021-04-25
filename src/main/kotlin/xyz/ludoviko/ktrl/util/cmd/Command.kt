package xyz.ludoviko.ktrl.util.cmd

interface Command {

    fun id(): Int

    fun text(): String

    fun command(): String
}