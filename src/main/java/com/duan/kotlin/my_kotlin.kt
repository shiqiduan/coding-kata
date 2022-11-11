package com.duan.kotlin

open class Shape

class Rectangle(var height: Double, var length: Double) : Shape() {
    var perimeter = (height + length) * 2;
}


fun main() {
    /**
     * aaaa
     */
    println("Hello world!")
    // aaa
    print(sum1(1, 100)) // aa
    printSum(10, 90)

    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")


    var a = 1
    var s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a}"
    println(s2)

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                else -> "Unknown"
            }

    println(describe(1L))
    println(describe(1))
    println(describe(0))

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        print("fits in range $x")
    }
    for (x in 1..y + 1) {
        println("fits in range $x")
    }

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    when {
        "kiwi" in items -> println("kiwi is fine too")
        "apple" in items -> println("apple is fine too")
    }

    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.uppercase() }
            .forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun sum1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    print("sum of $a and $b is ${a + b}")
}

val PI = 3.14
var x = 0

fun incrementX(): Int {
    x += 1
    return x
}

fun maxOf(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxOf1(a: Int, b: Int) = if (a > b) a else b