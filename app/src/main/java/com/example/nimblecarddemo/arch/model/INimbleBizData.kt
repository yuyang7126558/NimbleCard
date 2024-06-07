package com.example.nimblecarddemo.arch.model

/**
 * Created by colin.yu on 2024/05/21
 * @author colin.yu@bytedance.com
 */
interface INimbleData {
    /** Render type
     *  Define render engine by native & lynx
     * */
    val renderType: Int
    /**
     * use to define the only template
     * */
    val cardType: Int
}