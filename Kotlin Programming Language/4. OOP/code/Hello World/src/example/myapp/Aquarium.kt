package example.myapp

class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
    var length: Int = length
    var width: Int = width
    var height: Int = height
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
        println("Secondary Constructor")
    }
    init {
        println("aquarium initializing : Primary Constructor")
    }   // init functions are called in the order of their definition
    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }
    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l")
    }
    // property getter
    var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        set(value) {
            println("Setting value to volume") // we don't use print statements normally in setters
            height = (value * 1000) / (width * length)
        }
}