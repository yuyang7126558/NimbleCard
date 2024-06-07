package com.example.nimblecarddemo.arch.model

/**
 * Tako mix feed
 *
 * base biz data
 *
 * @constructor Create empty Tako mix feed
 */
data class TakoMixFeed(
    var text : String,
    var image: Int, override val cardType: Int
) : INimbleData {
    override val renderType: Int
        get() = 1
}
