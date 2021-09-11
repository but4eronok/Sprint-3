package ru.sber.oop

interface Fightable {
    val powerType: String
    var healthPoints: Int
    val damageRoll: Int
        get() = (1..10).random()

    fun attack(opponent: Fightable): Int

}

class Player : Fightable {
    val name: String = "Geralth of Rivia"

    var isBlessed : Boolean? = null
    override val powerType = "Agility"
    override var healthPoints = 100
    override val damageRoll = super.damageRoll

    override fun attack(opponent: Fightable): Int {
        var resultDamage = damageRoll

        if (isBlessed == true) {
            resultDamage *= 2

            opponent.healthPoints -= resultDamage
        }
        else {
            opponent.healthPoints -= resultDamage
        }
        return resultDamage
    }


}

abstract class Monster : Fightable {
    abstract val name : String
    abstract val description : String

    override fun attack(opponent: Fightable): Int {
        val resultDamage = damageRoll

        opponent.healthPoints -= resultDamage
        return resultDamage
    }

    fun getSalutation(): String = "Hello " + this.name + "  lets begin the fight!"
}

class Goblin : Monster() {
    override val name = "Dark cave Goblin"
    override val description = "A big and strong Goblin with slow attacks"
    override val powerType = "Strength"
    override var healthPoints = 150
    override val damageRoll = super.damageRoll / 2

    override fun attack(opponent: Fightable): Int {
        val resultDamge = damageRoll

        opponent.healthPoints -= resultDamge
        return resultDamge
    }
}


