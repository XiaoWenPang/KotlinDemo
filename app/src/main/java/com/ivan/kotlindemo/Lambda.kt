package com.ivan.kotlindemo

fun main() {
    test1()
    println("test3(2, 3): ${test3(2, 3)}")
    println("test4(5, 8): ${test4(5, 8)}")
    test5()
}

/**
 * 无参数情况
 */
fun test() {
    println("无参数")
}
//lambda代码
val test1 = { println("无参数") }

/**
 * 有参数
 */
fun test2(a: Int, b: Int): Int {
    return a + b
}
//lambda代码
val test3:(Int, Int) -> Int = { a, b -> a + b }
val test4 = { a: Int, b: Int -> a + b } //类型推断

fun test5() {
    val arr = arrayOf(1,2,3,4,5)
    println("test5(): ${arr.filter { it < 5 }.component1()}")
    println("----- ----- -----")
    println("test5(): ${arr.filter { it < 5 }}")

    val map = mapOf("key1" to "value1", "key2" to "value2", "key3" to "value3")
    map.forEach { (_, value) -> //(key, value) 因为没有使用第一个参数，所以第一个参数可以用 _ 替代 -> (_, value)
        println(value)
    }
}