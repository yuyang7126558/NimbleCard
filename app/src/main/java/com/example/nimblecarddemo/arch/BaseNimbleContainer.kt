package com.example.nimblecarddemo.arch

import android.content.Context
import android.view.ViewGroup

/**
 * Created by colin.yu on 2024/5/28
 *
 * @author colin.yu@bytedance.com
 */
abstract class BaseNimbleContainer(context: Context) : ViewGroup(context) {

    var containerLayout: ViewGroup? = null

    /** Parse component style */
    open fun parseStyle() {}

    /**
     * Generate layout by style
     *
     * @return
     */
    open fun generateLayout(): ViewGroup? = null

    /** Add to parent */
    open fun addToViewGroup() {}

    /** On Container click */
    abstract fun onContainClick()
}