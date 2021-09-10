package ru.sber.oop

open class Room(val name: String, val size: Int) {

    constructor(name: String) : this(name, size = 100) {

    }

    protected open val dangerLevel = 5

    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."

}

class TownSquare() : Room("Town Square", 1000) {
    final override fun load() = "Big and lonely Town Square, nothing dangerous"
    override var dangerLevel = super.dangerLevel - 3


}
