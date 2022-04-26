package com.ivan.kotlindemo

import android.view.View
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    Dog(11)
    println(Shop())
    println(Shop().isClose)

    val test = Test()
    test.setUp()
    test.test()
    testDataUtil()
    testStudent()

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

/**
 * 抽象类的定义和使用
 */
abstract class Printer() {
    abstract fun print()
}
class FilePrinter: Printer() {
    override fun print() {
        println("print file")
    }
}

/**
 * 接口的定义和使用
 * Kotlin中接口可以有自己的方法实现
 */
interface Study {
    val time: Int //抽象的，未实现的属性要在实现接口类的主构造方法中override
    fun discuss()
    fun learnCourse() {
        println("Android 架构师")
    }
}
class StudyAS(override val time: Int) : Study {
    override fun discuss() {
        TODO("Not yet implemented")
    }
}

/**
 * 两个接口有相同方法的情况
 */
interface A {
    fun foo() {
        println("A")
    }
}
interface B {
    fun foo() {
        println("B")
    }
}
class D: A, B {
    override fun foo() {
        //super.foo() //报错，因为不知道调用A的foo()还是B的foo()
        super<A>.foo() //指定调用谁的方法
    }
}

/**
 * 数据类
 * 1.主构造方法必须有参数
 * 2.数据类型不能定义为open,因为数据类不能被继承
 */
data class Address(var name: String, val number: Int) {
    var city: String = ""
    fun print() {
        println(city)
    }
}

/**
 * 对象表达式与对象声明
 */
open class Address2(name: String) {
    open fun print() {

    }
}
class Shop2{
    var address: Address2 ?= null
    fun addAddress(address: Address2) {
        this.address = address
    }
}
fun test3() {
    //在不创建新的子类的情况下，对类进行一些修改
    //如果超类型有一个构造方法，则必须传递适当的构造方法参数给它
    Shop2().addAddress(object : Address2("Android") {
        override fun print() {
            super.print()
        }
    })
}
fun foo() {
    //如果需要创建一个新的类，不一定需要创建对象，也可以采用这种对象声明的方式创建一个类
    //这是一个匿名对象
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    println(adHoc.x + adHoc.y)
}

object DataUtil {
    //可以将isEmpty理解为DataUtil中的一个静态对象
    fun<T> isEmpty(list: ArrayList<T>?): Boolean {
        return list?.isEmpty() ?: false //不确定list是否为空，所以加个？
    }
}
fun testDataUtil() {
    val list = arrayListOf("1")
    println(DataUtil.isEmpty(list))
}

/**
 * 伴生对象
 * 和Java的静态字段和静态方法相似
 */
class Student(val name: String) {
    companion object{
        val student = Student("Android")
        fun study() {
            println("Android 架构师")
        }
    }
}
fun testStudent() {
    println(Student.student)
    Student.study()
}