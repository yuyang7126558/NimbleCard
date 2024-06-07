package com.example.nimblecarddemo.arch.components

import ComponentTag
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.nimblecarddemo.arch.INimbleComponent
import com.example.nimblecarddemo.arch.model.TakoMixFeed

/**
 * Created by colin.yu on 2024/5/27
 *
 * @author colin.yu@bytedance.com
 */
class TextViewComponent(override val componentTag: ComponentTag = ComponentTag.TEXT, val context: Context) :
    INimbleComponent<TakoMixFeed> {

    private var bizData: TakoMixFeed? = null
    private var componentView: TextView = TextView(context)

    override fun getComponentView(): View? {
        return componentView
    }

    override fun getBizData(): TakoMixFeed? {
        return bizData
    }

    override fun onBind(data: TakoMixFeed) {
        bizData = data
        componentView?.let {
            it.textSize = 20f
            it.text = data.text
            it.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                weight = 1f
            }
            it.visibility = View.VISIBLE
        }
    }

    override fun onClick() {
        TODO("Not yet implemented")
    }
}