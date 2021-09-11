package main.kotlin.ru.sber.oop

import ru.sber.oop.Goblin
import ru.sber.oop.Player

fun main() {
    val player = Player()
    player.isBlessed = true
    val goblin = Goblin()
    do {
        player.attack(goblin)
        println("Goblin health is " + goblin.healthPoints)
        goblin.attack(player)
        println("Geralth health is " + player.healthPoints)
    } while (player.healthPoints > 0 && goblin.healthPoints > 0)
}

