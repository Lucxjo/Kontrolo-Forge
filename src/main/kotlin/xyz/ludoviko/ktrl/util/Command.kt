package xyz.ludoviko.ktrl.util

interface Command {

    fun id(): Int

    fun translationKey(): String

    fun command(): String
}