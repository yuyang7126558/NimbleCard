package com.example.nimblecarddemo.arch.components

import com.example.nimblecarddemo.arch.INimbleComponent
import com.example.nimblecarddemo.arch.model.TakoMixFeed
import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Created by colin.yu on 2024/5/31
 *
 * @author colin.yu@bytedance.com
 */
class ComponentsCachePool {

    // for test
    private val components: Queue<INimbleComponent<TakoMixFeed>> = ConcurrentLinkedQueue()
}