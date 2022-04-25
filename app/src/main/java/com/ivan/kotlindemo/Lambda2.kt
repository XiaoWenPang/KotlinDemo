package com.ivan.kotlindemo

fun main() {
    test1()
    literal()
}

data class Result(val message: String, val code: Int)

/**
 * 解构对象
 */
fun test1() {
    var result = Result("Success", 0)
    val (msg, code) = result
    println("Message: $msg, Code: $code")
}

/**
 * 匿名方法
 * 没有方法名
 */
val fun1 = fun(x: Int, y: Int): Int = x + y
val fun2 = fun(x: Int, y: Int): Int {
    return x + y
}

/**
 * 方法的字面值
 * 定义一个变量temp，而该变量的类型就是 (Int) -> Boolean
 */

fun literal() {
    //{num -> (num > 10)} 方法字面值
    var temp: ((Int) -> Boolean)? = null
    temp = {num -> (num > 10)}
    println("temp(11): ${temp(11)}")
}