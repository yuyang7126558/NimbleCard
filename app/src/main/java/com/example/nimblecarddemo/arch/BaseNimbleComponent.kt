package com.example.nimblecarddemo.arch

import ComponentTag
import android.view.View
import com.example.nimblecarddemo.arch.model.INimbleData

/**
 * Base nimble component
 *
 * @constructor Create empty Base nimble card component
 */
interface INimbleComponent<BIZ_DATA : INimbleData> {

    val componentTag: ComponentTag

    /**
     * Get component view for assem to container
     *
     * @return view
     */
    fun getComponentView(): View?

    /**
     * Get current biz data
     *
     * @return
     */
    fun getBizData(): BIZ_DATA?

    /**
     * On bind data and update View
     *
     * @param data
     */
    fun onBind(data: BIZ_DATA)

    /** On component click action*/
    fun onClick()
}