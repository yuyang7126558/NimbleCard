package com.example.nimblecarddemo.arch.manager

import RootJson
import Template
import android.content.Context
import com.google.gson.Gson

/**
 * Created by colin.yu on 2024/5/27
 *
 * @author colin.yu@bytedance.com
 */
object NimbleTemplatesLoader {

    private const val FILE_NAME = "templates.json"
    private lateinit var templates: List<Template>

    /**
     * Initialize
     *
     * @param context
     */
    fun initialize(context: Context) {
        templates = loadJsonFromAsset(FILE_NAME,context).templates
    }

    private fun loadJsonFromAsset(fileName: String, context: Context): RootJson {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(jsonString, RootJson::class.java)
    }


    /**
     * Get template by card type
     *
     * @param type
     * @return
     */
    open fun getTemplateByCardType(type : Int): Template? {
        templates.forEach {
            if (it.type == type) {
                return it
            }
        }
        return null
    }
}