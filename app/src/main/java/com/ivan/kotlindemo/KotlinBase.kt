package com.ivan.kotlindemo

import kotlin.math.abs

fun main() {
    println("------ MAIN ------")
    baseType()
    arrayType()
}

fun baseType() {
    val num1 = -1.68 //Double
    val num2 = 2 //Int

    val num3 = 2f //Float
    val int1 = 3
    println("num1:$num1 num2:$num2 num3:$num3 int1:$int1")

    println(abs(num1)) //求绝对值
    println(num1.toInt()) //转换成int
    printType(num1)
    printType(num2)
    printType(num3)
    printType(int1)
}

fun arrayType() {
    val array = arrayOf(1,2,3) //arrayOf

    val array1 = arrayOfNulls<Int>(3) //arrayOfNulls
    array1[0] = 4
    array1[1] = 5
    array1[2] = 6

    val array2 = Array(5) {i -> (i*i).toString()} //Array的构造函数

    val x = intArrayOf(1,2,3) //intArrayOf()、doubleArrayOf()
    println("x[0] + x[1] = ${x[0] + x[1]}")

    val array3 = IntArray(5) //大小为5，值为[0,0,0,0,0]的整形数组
    val array4 = IntArray(5) { 42 } //[42,42,42,42,42]

    val array5 = IntArray(5) {it * 1} //{}\\[0,1,2,3,4]
    println(array5[4])

    /** 遍历数组的常用5种方式 **/
    //数组遍历
    for(item in array) {
        println(item)
    }
    //带索引遍历数组
    for(i in array.indices) {
        println("$i -> ${array[i]}")
    }
    //遍历元素(带索引)
    for((index, item) in array.withIndex()) {
        println("$index --> $item")
    }
    //forEach
    array.forEach { println(it) }
    //forEach增强版
    array.forEachIndexed{index, item -> println("$index -> $item")}
}

fun printType(param: Any) { //打印对象类型
    println("$param is ${param::class.simpleName}")
}
