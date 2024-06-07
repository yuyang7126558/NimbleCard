package com.example.nimblecarddemo.arch.handlers

import Component
import ComponentTag
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nimblecarddemo.arch.INimbleComponent
import com.example.nimblecarddemo.arch.components.ImageViewComponent
import com.example.nimblecarddemo.arch.components.TextViewComponent
import com.example.nimblecarddemo.arch.model.TakoMixFeed

/**
 * Component handler
 *
 * @constructor Create empty Component handler
 */
class ComponentHandler {

    companion object {

        /**
         * Parse component
         *
         * At first try to get Component from cache if not, then instance new one
         *
         * @param component
         * @param bizData
         * @param T
         * @return
         */
        fun parseComponent(component: Component, parent: View): INimbleComponent<TakoMixFeed>? {
            when (component.tag) {
                ComponentTag.TEXT.tag -> {
                    // text component  text assem component
                    return TextViewComponent(context = parent.context)
                }

                ComponentTag.IMAGE.tag -> {
                    // text component  text assem component
                    return ImageViewComponent(context = parent.context)
                }

                else -> {
                    return null
                }
            }
        }
    }

    interface ComponentGenerator {

        /**
         * Create tako component
         *
         * @param parent
         * @param async
         * @return
         */
        fun createTakoComponent(parent: ViewGroup, async: Boolean = false): ViewGroup?

        /**
         * Create search component
         *
         * @param parent
         * @param async
         * @return
         */
        fun createSearchComponent(parent: ViewGroup, async: Boolean = false): RecyclerView.ViewHolder?
    }
}
