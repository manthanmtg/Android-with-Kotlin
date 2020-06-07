# Kotlin Basics
##### when
- can accept ranges too
```kotlin
when (numberOfFish) {
    0  -> println("Empty tank")
    in 1..39 -> println("Got fish!")    // can accept ranges
    else -> println("That's a lot of fish!")
}
```
⇒ That's a lot of fish!

### Nullabilty
##### By default, variables cannot be `null`.

Declare an Int and assign null to it.
```kotlin
var rocks: Int = null
```
⇒ error: null can not be a value of a non-null type Int

Use the question mark operator, `?`, after the type to indicate that a variable can be null. Declare an `Int?` and assign `null` to it.

When you have complex data types, such as a list:
- You can allow the elements of the list to be null.
- You can allow for the list to be null, but if it's not null its elements cannot be null.
- You can allow both the list or the elements to be null.

##### Learn about the ? and ?: operators
You can test for null with the ? operator, saving you the pain of writing many if/else statements.

1. Write some code the longer way to check whether the fishFoodTreats variable is not null. Then decrement that variable.

```kotlin
var fishFoodTreats = 6
if (fishFoodTreats != null) {
    fishFoodTreats = fishFoodTreats.dec()
}
```

2. Now look at the Kotlin way of writing it, using the ? operator.

```kotlin
var fishFoodTreats = 6
fishFoodTreats = fishFoodTreats?.dec()
```

3. You can also chain null tests with the ?: operator. Look at this example:

```kotlin
fishFoodTreats = fishFoodTreats?.dec() ?: 0
```
It's shorthand for "if `fishFoodTreats` is not `null`, decrement and use it; otherwise use the value after the `?:`, which is 0." If `fishFoodTreats` is `null`, evaluation is stopped, and the `dec()` method is not called.

> **Note:** The `?:` operator is sometimes called the "Elvis operator," because it's like a smiley on its side with a pompadour hairstyle, the way Elvis Presley styled his hair. Read more about [the Elvis operator](https://kotlinlang.org/docs/reference/null-safety.html#elvis-operator) in the Kotlin documentation.

##### A point about null pointers
If you really love `NullPointerExceptions`, Kotlin lets you keep them. The not-null assertion operator, `!!` (double-bang), converts any value to a non-null type and throws an exception if the value is `null`.

```kotlin
val len = s!!.length   // throws NullPointerException if s is null
```

> **Note:** In programming slang, the exclamation mark is often called a "bang," so the not-null assertion operator is sometimes called the "double-bang" or "bang bang" operator.

> Note: It's generally a bad idea to use the double-bang operator. That's why the language creators made you enter two exclamation marks instead of one. However, sometimes you need the double-bang when dealing with legacy Java code.

### Explore arrays, lists, and loops

##### Make lists
Lists are a fundamental type in Kotlin, and are similar to lists in other languages.

1. Declare a list using listOf and print it out. This list cannot be changed.

```kotlin
val school = listOf("mackerel", "trout", "halibut")
println(school)
```
> ⇒ `[mackerel, trout, halibut]`

2. Declare a list that can be changed using mutableListOf. Remove an item.
```kotlin
val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")
```
> ⇒ `res36: kotlin.Boolean = true`
The `remove()` method returns `true` when it successfully removes the item passed.

> Note: With a list defined with `val`, you can't change which list the variable refers to, but you can still change the contents of the list.

##### Create arrays
Like other languages, Kotlin has [arrays](https://kotlinlang.org/docs/reference/basic-types.html#arrays). Unlike lists in Kotlin, which have mutable and immutable versions, there is no mutable version of an `Array`. Once you create an array, the size is fixed. You can't add or remove elements, except by copying to a new array.

The rules about using `val` and `var` are the same with arrays as with lists.

> **Note:** With an array defined with `val`, you can't change which array the variable refers to, but you can still change the contents of the array.

1. Declare an array of strings using `arrayOf`. Use the `java.util.Arrays.toString()` array utility to print it out.

```kotlin
val school = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(school))
```
> ⇒ `[shark, salmon, minnow]`

2. An array declared with `arrayOf` doesn't have a type associated with the elements, so you can mix types, which is helpful. Declare an array with different types.

```kotlin
val mix = arrayOf("fish", 2)
```

3. You can also declare arrays with one type for all the elements. Declare an array of integers using `intArrayOf()`. There are corresponding builders, or instantiation functions, for arrays of other types.

```kotlin
val numbers = intArrayOf(1,2,3)
```
> **Note:** Using an array of a primitive type such as `Int` or `Byte` avoids the overhead of boxing.

4. Combine two arrays with the `+` operator.

```kotlin
val numbers = intArrayOf(1,2,3)
val numbers3 = intArrayOf(4,5,6)
val foo2 = numbers3 + numbers
println(foo2[5])
```
> => `3`

5. Try out different combinations of nested arrays and lists. As in other languages, you can nest arrays and lists. That is, when you put an array within an array, you have an array of arrays—not a flattened array of the contents of the two. The elements of an array can also be lists, and the elements of lists can be arrays.

```kotlin
val numbers = intArrayOf(1, 2, 3)
val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)
```
> ⇒ `[[I@89178b4, [Atlantic, Pacific], salmon]`

The first element, `numbers`, is an `Array`. When you don't use the array utility to print it, Kotlin prints the address instead of the contents of the array.

6. One nice feature of Kotlin is that you can initialize arrays with code instead of initializing them to 0. Try this example:

```kotlin
val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))
```
> ⇒ `[0, 2, 4, 6, 8]`

The initialization code is between the curly braces, `{}`. In the code, `it` refers to the array index, starting with 0.

##### Make loops
Now that you have lists and arrays, looping through the elements works as you might expect.

1. Create an array. Use a `for` loop to iterate through the array and print the elements.

```kotlin
val school = arrayOf("shark", "salmon", "minnow")
for (element in school) {
    print(element + " ")
}
```

> ⇒ `shark salmon minnow`

2. In Kotlin, you can loop through the elements and the indexes at the same time. Try this example:

```kotlin
for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}
```
> ⇒ `Item at 0 is shark`
`Item at 1 is salmon`
`Item at 2 is minnow`

3. Try different step sizes and ranges. You can specify ranges of numbers or of characters, alphabetically. And as in other languages, you don't have to step forward by 1. You can step backward using `downTo`.

```kotlin
for (i in 1..5) print(i)
⇒ 12345

for (i in 5 downTo 1) print(i)
⇒ 54321

for (i in 3..6 step 2) print(i)
⇒ 35

for (i in 'd'..'g') print (i)
⇒ defg
```
> **Caution:** Python range excludes the last number

4. Try out some loops. Like other languages, Kotlin has while loops, do...while loops, and ++ and -- operators. Kotlin also has repeat loops.

```kotlin
var bubbles = 0
while (bubbles < 50) {
    bubbles++
}
println("$bubbles bubbles in the water\n")

do {
    bubbles--
} while (bubbles > 50)
println("$bubbles bubbles in the water\n")

repeat(2) {
     println("A fish is swimming")
}
```
> ⇒ `50 bubbles in the water`
`49 bubbles in the water`
`A fish is swimmingA fish is swimming`

### Summary
Kotlin is very similar to other languages when it comes to the basics like operators, lists, and loops, but there are some important differences.

The following features may be different in Kotlin than what you're used to in other languages:
- Kotlin types can't be implicitly converted—use casting.
- Variables declared with `val` can only be assigned once.
- Kotlin variables are not nullable by default. Use `?` to make variables nullable.
- With Kotlin, you can loop through the index and elements of an array at the same time in a `for` loop.

The following Kotlin programming constructs are similar to those in other languages:
- Arrays and lists can have a single type or mixed types.
- Arrays and lists can be nested.
- You can create loops with `for`, `while`, `do`/`while`, and `repeat`.
- The `when` statement is Kotlin's version of the `switch` statement, but `when` is more flexible.

