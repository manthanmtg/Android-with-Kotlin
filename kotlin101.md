# Kotlin 101
#### What is Kotlin
- Modern prog. lang
- OOP + FP
- Statically typed
- Open Source (Apache 2.0)
- Created by JetBrains
- Adopted by Google

#### Kotlin Evolution
- 2010 : Project Started
- 2016 : Kotlin 1.0
- 2017 : Officially supported on Android
- 2019 : Android becomes kotlin-first
- 2020 : Kotlin 1.4 Preview

#### Why Kotlin?
- Concise / Expressive
- Code Safety (Prevents null pointer exceptions)
- Interoperability (100% interoperable with java)
- Tool-friendly
- Structured concurrency
- #4 Most loved language on Stack Overflow

### Basic Syntax
#### Mutable Variable
```kotlin
var num: Int = 1
```
#### Immutable Variable
```kotlin
val greeting = "Hello"
```
Use `val` more.
Kotlin has inbuilt type inference
#### Basic DataTypes
```kotlin
Int
Double
Boolean
Char
String
```
Beware of capital I in Int

#### Simple Program
```kotlin
fun main() {
    println("Hello World!")
} // main function is the entrypoint to kotlin program
```

### Function
Main.kt
```kotlin

fun addNumbers (num1: Int, num2: Int): Int {
    return num1 + num2
}

/*
fun function_name(parameter: par_type): return type {
    ...
}
*/
fun main() {
    val number1 : Int = 10
    val number2 = 20
    val total = addNumbers(number1, number2)
    println("Sum of two numbers: $total")

}
```

#### Compact Functions
```kotlin
fun double(x: Int): Int {
    x * 2
}   // complete version

fun double(x: Int): Int = x*2   // compact version
```

#### Lambdas
```kotlin
var dirtyLevel = 20
val waterFilter = {dirty : Int -> dirty / 2}
println(waterFilter(dirtyLevel))
```

#### Higher Order Functions
```kotlin
fun encodeMsg(msg: String, encode: (String) -> String): String {
    return encode(msg)
}

val enc1: (String) -> String = {input -> input.toUpperCase()}
println(encodeMsg("abc", enc1))
```

## Concise/Readability
- Easy to read
- Easy to manage
- Reduces Code Size

## Code Safety
```kotlin
// The Billion Dollar Mistake
var playerName: String
player = null // Compilation Error

// Kotlin protects you from mistakenly operating on nullable types
val playerFirstName = String? = null    // Nullable type
println(playerFirstName.length())       // Compilation Error

// And if you check a type is right, the compiler will auto-cast it for you
// Any type is the super type for all the non nullable types
fun playerProfile(obj: Any) {
    if (obj is EscortPlayer) // Auto-cast
    {
        println("Player In-Game Name ${obj.playerIGN}")
    }
}
```

## Interoperability
- Java classes can be used inside kotlin code as if it were a kotlin code

## Tool Friendly
- IntelliJ IDEA
- Android Studio
- Eclipse
- Command Line

## Why one language is not enough?
.........................

## Build Applications For Multiplatform
- Kotlin/JVM (Android)
- Kotlin/JS (Browser)
- Kotlin/JVM (Server)
- Kotlin/Native (iOS/Embedded System)

## Kolin For Android

#### Expressiveness
- Lambdas
- Data Classes
- Scope Fucntions
- Property access syntax

#### Safety
- Nullability baked into the type system

#### Interoperability
- 100% interoperable with Java Programming Language

#### Structured Concurrency
- Run async operations in a scope, avoid leaking work and memory

#### Kotlin is production-ready for your Android App Development
- Android Studio
- Android KTX (makes kotlin code more concise)
- Kotlin-friendly SDK
- Learning Resources

## Coroutines
- Way of handling multiple tasks

#### Multiple tasks in an App eg.,
- Downloading info
- Scheduling system calls
- Uppdating network resources
- Database access
- Many more tasks...

## Coroutines in Kotlin
- Structured concurrency
- Lightweight
- Callback-free, sequential code
- Built-in cancellation support
- Main-thread safe


