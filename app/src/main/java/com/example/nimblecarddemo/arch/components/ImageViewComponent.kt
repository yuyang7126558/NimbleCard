package com.example.nimblecarddemo.arch.components

import ComponentTag
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.nimblecarddemo.arch.INimbleComponent
import com.example.nimblecarddemo.arch.model.TakoMixFeed

/**
 * Created by colin.yu  on 2024/6/4
 * @author colin.yu@bytedance.com
 */
class ImageViewComponent(override val componentTag: ComponentTag = ComponentTag.IMAGE, val context: Context) :
    INimbleComponent<TakoMixFeed> {

    private var bizData : TakoMixFeed? = null
    private var componentView: ImageView? = ImageView(context)

    override fun getComponentView(): View? {
        return componentView
    }

    override fun getBizData(): TakoMixFeed? {
        return bizData
    }

    override fun onBind(data: TakoMixFeed) {
        bizData = data
        componentView?.let {
            it.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        (this.componentView as ImageView).setImageResource(data.image)
        (this.componentView as ImageView).visibility = View.VISIBLE
    }

    override fun onClick() {
        TODO("Not yet implemented")
    }
}