package example.myapp

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    println("---------------------------------")
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    println("---------------------------------")
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    println("---------------------------------")
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    println("---------------------------------")
    val aquarium5 = Aquarium(37, 34, 24)
    aquarium5.printSize()
    println("---------------------------------")
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}