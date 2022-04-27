package com.ivan.kotlindemo

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

/**
 * 为Activity添加find扩展方法，用于通过资源id获取控件
 */
fun <T: View> Activity.find(@IdRes id: Int): T {
    return findViewById(id)
}
/**
 * 为资源id添加onClick扩展方法，用于为资源id对应的控件添加onClick监听
 */
fun Int.onClick(activity: Activity, click: () -> Unit) {
    activity.find<View>(this).apply {
        setOnClickListener {
            click()
        }
    }
}