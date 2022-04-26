package com.ivan.kotlindemo

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println(list)

    val listString = mutableListOf("A", "B", "C")
    listString.swap2(0, 2)
    println(listString)

    println("\"1,2,3,4,5,6\".lastChar: ${"1,2,3,4,5,6".lastChar}")

    Jump.print("123")

    testApply()
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 泛型扩展
 */
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展属性
 * 案例：为String添加一个lastChar属性，用于获取字符串的最后一个字符
 */
val String.lastChar: Char get() = this.get(this.length - 1)

/**
 * 伴生对象的扩展
 */
class Jump {
    companion object {}
}
fun Jump.Companion.print(str: String) {
    println(str)
}

/**
 * let扩展
 */
fun testLet(str: String?) {
    //避免为null的操作
    str?.let {
        println(it.length)
    }

    //限制作用域
    str.let {
       val str2 = "let作用域"
        println(it + str2)
    }
    //str2 无法访问
}

/**
 * run扩展
 */
data class Room(val address: String, val price: Float, val size: Float)
fun testRun(room: Room) {
    //room.address
    //room.price
    //在run代码块内可以直接访问属性,不需要对象 + . 的方式访问属性
    room.run {
        println("Room: $address, $price, $size")
    }
}

/**
 * apply扩展
 */
fun testApply() {
    ArrayList<String>().apply {
        add("1")
        add("2")
        add("3")
    }.let {
        println(it)
    }
}