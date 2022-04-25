package com.ivan.kotlindemo

import javax.security.auth.callback.Callback

fun main() {
    test1()
    println("test3(2, 3): ${test3(2, 3)}")
    println("test4(5, 8): ${test4(5, 8)}")
    test5()

    val list = listOf(1,2,3)
    val result = list.sum {
        println("it: ${it}")
    }
    println("List.sum: $result")

    val listString = listOf("1","2","3","4")
    val result2 = listString.toIntSum()(2)
    println("listString.toIntSum: $result2")

    testClosure(1)(2) {
        println(it)
    }
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

    map.apply {  }
}

/**
 * 高阶函数--函数作为参数
 * 扩展集合函数 -> 几何元素求和,每次遍历都有回调
 */
fun List<Int>.sum(callback: (Int) -> Unit): Int {
    var result = 0
    for(v in this) {
        result += v
        callback(v)
    }
    return result
}

/**
 * 高阶函数--函数作为返回值
 * 实现一个能够对集合元素进行求和的高阶函数，并且返回一个声明为 (scale: Int) -> Float 的函数
 */
fun List<String>.toIntSum(): (scale: Int) -> Float {
    println("第一层函数")
    return fun(scale): Float {
        var result = 0f
        for(v in this) {
            result += v.toInt() * scale
        }
        return result
    }
}

/**
 * 闭包
 * 需求：实现一个接受一个testClosure方法，该方法接受一个Int类型的v1参数，
 * 同时能够返回一个声明为 (v2: Int, (Int) -> Unit) 的函数，并且这个函数能够计算v1与v2的和
 * 调用： testClosure(1)(2) { println(it) }
 */
fun testClosure(v1: Int): (v2: Int, (Int) -> Unit) -> Unit {
    return fun(v2: Int, printer: (Int) -> Unit) {
        printer(v1 + v2)
    }
}
