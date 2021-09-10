package ru.sber.oop

data class User(val name: String, val age: Long) {
    lateinit var city: String

    override fun equals(other: Any?): Boolean {
        if (other is User) {
            if (other.age == this.age && other.name == this.name && other.city == this.city)
                return true
        }
        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + city.hashCode()
        return result
    }

}

fun main() {
    val user1 = User("Alex", 13)
    val user2 = user1.copy("Kirill")

    user1.city = "Omsk"

    val user3 = user1.copy()
    user3.city = "Omsk"

    println(user1.equals(user3))
}