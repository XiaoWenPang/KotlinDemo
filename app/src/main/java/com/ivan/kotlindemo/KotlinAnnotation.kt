package com.ivan.kotlindemo

fun main() {
    fire(ApiGetArticles())
}

/**
 * JAVA注解
 * @interface ApiDoc {
 *    String value();
 * }
 */
//@Target(AnnotationTarget.CLASS) 如果添加这个注解，则该注解只能添加到类上
annotation class ApiDoc(val value: String)

@ApiDoc("修饰类")
class Box {
    @ApiDoc("修饰字段")
    val size = 6
    @ApiDoc("修饰方法")
    fun test() {}
}

/**
 * 案例：自定义注解实现API调用时的请求方法检查
 */
public enum class Method {
    GET,
    POST
}

@Target(AnnotationTarget.CLASS) //设置对象
@Retention(AnnotationRetention.RUNTIME) //保留时期 -> 运行时可见
annotation class HttpMethod(val method: Method)

interface Api {
    val name: String
    val version: String
        get() = "1.0"
}
@HttpMethod(Method.GET)
class ApiGetArticles: Api {
    override val name: String
        get() = "/api.articles"
}
fun fire(api: Api) {
    val annotation = api.javaClass.annotations//通过反射获取注解
    val method = annotation.find { it is HttpMethod } as? HttpMethod
    println("通过注解得知该接口需要通过：${method?.method} 方式请求")
}