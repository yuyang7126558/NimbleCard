package com.example.nimblecarddemo.arch

import Template
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nimblecarddemo.arch.handlers.ComponentHandler.Companion.parseComponent
import com.example.nimblecarddemo.arch.handlers.StyleHandler
import com.example.nimblecarddemo.arch.manager.NimbleTemplatesLoader
import com.example.nimblecarddemo.arch.model.INimbleData
import com.example.nimblecarddemo.arch.model.TakoMixFeed

/**
 * Created by colin.yu on 2024/05/28
 *
 * @author colin.yu@bytedance.com
 */
class NimbleCard<T : INimbleData>(var cardType : Int, itemView: View) : ViewHolder(itemView) {

    private var container: ViewGroup? = null
    private var template: Template? = null
    private var componentsList: MutableList<INimbleComponent<TakoMixFeed>> = mutableListOf()
    private var bizData: T? = null

    init {
        generateContainer() // create container by style
        parseComponents() // parseComponents by template
    }

    /**
     * On view created
     *
     * @param view
     */
    private fun generateContainer() {
        template = NimbleTemplatesLoader.getTemplateByCardType(cardType)
        template?.let {
            var style = it.style
            container = StyleHandler.parseStyle(style, itemView.context)
            (itemView as FrameLayout).addView(container)
        }
    }

    private fun parseComponents() {
        val components = template?.components
        components?.let {
            it.forEach {
                var componentInstance = container?.let { parentView -> parseComponent(it, parentView) }
                componentInstance?.let {
                    addViewToContainer(componentInstance.getComponentView())
                    componentsList.add(componentInstance)
                }
            }
        }
    }

    private fun addViewToContainer(view: View?) {
        view?.let {
            StyleHandler.run { template?.style?.let { it1 -> addViewToContainer(it, container, it1.layout) } }
        }
    }

    fun bindData(data: T) {
        bizData = data
        container?.visibility = View.VISIBLE
        componentsList.forEach {
            it.onBind(bizData as TakoMixFeed)
        }

        container?.requestLayout()
    }
}