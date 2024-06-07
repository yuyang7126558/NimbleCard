package com.example.nimblecarddemo.arch.containers

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout


/**
 * Created by colin.yu on 2024/5/28
 *
 * @author colin.yu@bytedance.com
 */
class RelativeLayoutContainer {
    companion object {
        var layoutParams: LinearlayoutParams? = null

        fun generateRootView(context: Context, params: LinearlayoutParams?): ViewGroup? {
            if (layoutParams != null) {
                layoutParams = params?.let { parseLayoutParams(it) }
            }

            return LinearLayout(context).apply {
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                )
                gravity = Gravity.CENTER_HORIZONTAL
                orientation = LinearLayout.VERTICAL
                clipChildren = false
            }
        }

        private fun parseLayoutParams(layoutParams: LinearlayoutParams): LinearlayoutParams? {
            return null
        }
    }
}

/**
 * Linearlayout params
 *
 * to expand for future
 *
 * @constructor Create empty Linearlayout params
 * @property direction
 */
data class RelativelayoutParams(
    val direction: String,
)
