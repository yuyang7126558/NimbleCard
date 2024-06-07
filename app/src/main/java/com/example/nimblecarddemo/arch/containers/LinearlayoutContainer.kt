package com.example.nimblecarddemo.arch.containers

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/**
 * Created by colin.yu on 2024/5/28
 *
 * @author colin.yu@bytedance.com
 */
class LinearlayoutContainer {
    companion object {
        var layoutParams: LinearlayoutParams? = null

        fun generateRootView(context: Context, subStyle: JsonObject?): ViewGroup? {
            if (subStyle != null) {
                layoutParams = subStyle?.let { parseLayoutParams(it) }
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

        private fun parseLayoutParams(layoutParams: JsonObject): LinearlayoutParams? {
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
data class LinearlayoutParams(
    @SerializedName("direction")
    val direction: String,
)
