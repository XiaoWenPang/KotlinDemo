package com.ivan.kotlindemo

fun main() {
    collectionType()
    collectionSort()
}

/**
 * 集合
 */
fun collectionType() {
    //不可变集合
    val stringList = listOf("one","two","one")
    println(stringList)

    val stringSet = setOf("one","two","one") //Set中元素唯一
    println(stringSet)

    //可变集合
    val numbers = mutableListOf(1,2,3,4)
    numbers.add(5)
    numbers.removeAt(1)
    numbers[0] = 0
    println(numbers)

    //Set集合
    val hello = mutableSetOf("H", "e", "l", "l", "o") //自动过滤重复元素
    hello.remove("o")
    println("Set Hello -> $hello") //Set Hello -> [H, e, l]
    //Set的加减操作
    hello += setOf("w","o","r","l","d") //前面的必须是可变集合
    println("Set Hello -> $hello") //Set Hello -> [H, e, l, w, o, r, d]

    //Map<K, V>不是Collection接口的继承者，但它也是Kotlin的一种集合类型
    val numberMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 4, "key5" to 5)
    println("All keys: ${numberMap.keys}")
    println("All values: ${numberMap.values}")

    if("key2" in numberMap) println("Value by key key2: ${numberMap["key2"]}") //判断key2是否在numberMap中
    if(1 in numberMap.values) println("1 is in the map") //判断1是否在numberMap中
    if(numberMap.containsKey("key2")) println("key2")
    if(numberMap.containsValue(1)) println(1)

    /**
     * Q1：两个具有相同键值对，但顺序不同的map相等吗？为什么？
     * 无论键值对顺序如何，包含相同键值对的两个Map是相等的
     * 等号相当于Map的equals()方法
     */
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key3" to 3, "key4" to 4, "key5" to 5)
    println("anotherMap == numberMap: ${anotherMap == numberMap}")

    /**
     * Q2：两个具有相同元素，但顺序不同的list相等吗？为什么？
     * 不相等
     */
    val anotherNumbers = mutableListOf(2,1,3,4)
    println("anotherNumbers == numbers: ${anotherNumbers == numbers}")
}

/**
 * 集合排序
 */
fun collectionSort() {
    val number3 = mutableListOf(1,2,3,4)
    //随机排序
    number3.shuffle()
    println(number3)

    number3.sort() //从小到大排序
    println(number3)
    println(" ------ ------ ------ ------")
    number3.sortDescending() //从大到小
    println(number3)
    println(" ------ ------ ------ ------")

    //条件排序
    data class Language(var name: String, var score: Int) //数据类
    val languageList: MutableList<Language> = mutableListOf()
    languageList.add(Language("Java", 80))
    languageList.add(Language("Kotlin", 90))
    languageList.add(Language("Dart", 99))
    languageList.add(Language("C", 80))
    //使用sortBy进行排序，适合单条件排序
    languageList.sortBy { it.score }
    println(languageList)

    println(" ------ ------ ------ ------")

    //使用sortWith进行排序，适合多条件排序
    languageList.sortWith(compareBy({it.score}, {it.name}))
    println(languageList)
}
