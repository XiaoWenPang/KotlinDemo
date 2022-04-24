package com.ivan.kotlindemo

/**
 * Kotlin 方法可以直接定义在文件里，Java只能定义在类里
 */
fun main() {
    println(functionLearn(101))
    println(functionLearn(99))
    Person().test1() //调用成员方法
    Person.test2() //调用类/静态方法
    println("NumUtil.double(2): ${NumUtil.double(2)}")
    println("double(3): ${double(3)}")
    println(append('a', 'b', 'c'))
    println("magic(): ${magic()}")
}

fun functionLearn(days: Int): Boolean {
    return days > 100
}

// Kotlin 的成员方法
class Person {
    fun test1() { //成员方法
        println("成员方法")
    }
    companion object { //定义类方法/静态方法
        fun test2() {
            println("companion object 实现类方法")
        }
    }
}

/**
 * 整个静态类
 */
object NumUtil{ //实现工具类
    fun double(num: Int): Int {
        return num * 2
    }
}

/**
 * 但表达式方法，当方法返回但表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
 */
fun double(x: Int): Int = x * 2

/**
 * 默认值，方法参数可以有默认值，当省略相应的参数时使用默认值。与Java相比可以减少重载的数量
 * off len
 */
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {}

/**
 * 可变数量的参数
 */
fun append(vararg str: Char): String {
    val result = StringBuffer()
    for(char in str) {
        result.append(char)
    }
    return result.toString()
}

/**
 * 局部方法
 */
fun magic(): Int {
    fun foo(v: Int): Int {
        return v * v
    }
    val v1 = (0..100).random()
    return foo(v1)
}