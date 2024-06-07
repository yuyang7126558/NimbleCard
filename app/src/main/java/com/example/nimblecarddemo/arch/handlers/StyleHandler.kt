package com.example.nimblecarddemo.arch.handlers

import NimbleLayout
import Style
import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.nimblecarddemo.arch.containers.LinearlayoutContainer

/**
 * Created by colin.yu on 2024/5/27
 *
 * @author colin.yu@bytedance.com
 */
class StyleHandler {

    companion object {
        /**
         * Parse style
         *
         * @param style
         * @param context
         * @return
         */
        fun parseStyle(style: Style, context: Context): ViewGroup? {
            when (style.layout) {
                NimbleLayout.LINERALAYOUT.tag -> {
                    return LinearlayoutContainer.generateRootView(context,null)
                }
                //
                else -> null
            }
            return null
        }

        /**
         * Add view to container
         *
         * @param view
         * @param container
         * @param tag
         */
        fun addViewToContainer(view: View, container: ViewGroup?, layout: String) {
            container?.let {
                when (layout) {
                    NimbleLayout.LINERALAYOUT.tag -> {
                        // call linearlayout add view fun
                        it.addView(view)
                    }
                }
            }
        }
    }

    // slot
}