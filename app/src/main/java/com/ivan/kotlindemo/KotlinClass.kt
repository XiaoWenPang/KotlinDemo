package com.ivan.kotlindemo

import android.view.View
import java.util.*

fun main() {
    Dog(11)
    println(Shop())
    println(Shop().isClose)

    val test = Test()
    test.setUp()
    test.test()

}

/**
 * 主构造方法
 */
class KotlinClass constructor(name: String) {
    /**
     * 次构造方法，必须调用主构造方法
     */
    constructor(view: View, name: String): this(name) {
        println("name: $name")
    }
    constructor(view: View, name: String, index: Int): this(name) {
        println("name: $name")
    }
}

/**
 * 继承
 * Kotlin中所有类都是final类型，不允许继承
 * 为父类添加open关键字后，可以继承
 */
open class Animal(age: Int) {
    init {
        //可以再init()中完成相关的初始化
        println(age)
    }
    open val foot: Int = 0
    open fun eat() {

    }
}

class Dog(age: Int) : Animal(age) {
    //val 初始化方式
    //1.定义的时候初始化
    //val simple: Int? = null
    //2.设置get方法
    val simple: Int?
        get() {
            return 1
        }
    //3.或者在构造方法中进行初始化

    //Kotlin 覆盖父类属性
    override val foot = 4

    //Kotlin 重写父类方法
    override fun eat() {
        super.eat()
    }
}

/**
 * 属性的声明
 */
class Shop {
    val name: String = "Android"
    var address: String? = null
    val isClose: Boolean
        get() = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 11
    var score: Float = 0.0f
        get() = if(field < 0.2f) 0.2f else field * 1.5f
        set(value) {
            println("value: $value")
        }
}

/**
 * 延时初始化
 * 用于依赖注入等
 */
class Test {
    lateinit var shop: Shop //用lateinit修饰的属性可以延时初始化
    fun setUp() {
        shop = Shop()
        shop.address = "BeiJing"
    }
    fun test() {
        //::表示创建成员引用或类引用
        if(::shop.isInitialized) println(shop.address)
    }
}