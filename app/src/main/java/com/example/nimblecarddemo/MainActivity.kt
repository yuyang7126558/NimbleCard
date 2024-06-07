package com.example.nimblecarddemo

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nimblecarddemo.arch.manager.NimbleTemplatesLoader
import com.example.nimblecarddemo.arch.model.TakoMixFeed

class MainActivity : ComponentActivity() {

    private val mContext: Context = this@MainActivity
    private lateinit var mRecyclerView: RecyclerView
    private val titles = arrayOf(
        "美食",
        "电影",
        "酒店住宿",
        "休闲娱乐",
        "外卖",
        "自助餐",
        "KTV",
        "机票/火车票",
        "周边游",
        "美甲美睫",
        "火锅",
        "生日蛋糕",
        "甜品饮品",
        "水上乐园",
        "汽车服务",
        "美发",
        "丽人",
        "景点",
        "足疗按摩",
        "运动健身",
        "健身",
        "超市",
        "买菜",
        "今日新单",
        "小吃快餐",
        "面膜",
        "洗浴/汗蒸",
        "母婴亲子",
        "生活服务",
        "婚纱摄影",
        "学习培训",
        "家装",
        "结婚",
        "全部分配"
    )
    private val datas: MutableList<TakoMixFeed?> = ArrayList()
    private var myAdapter: NimbleAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {
        //初始化data
        for (i in titles.indices) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
            val imageId: Int = getResources().getIdentifier("ic_category_$i", "mipmap", getPackageName())
            datas.add(TakoMixFeed(titles[i], imageId,i))
        }

        var testTextImage = TakoMixFeed("文字前", getResources().getIdentifier("ic_category_10", "mipmap", getPackageName()), 1000)
        var testImageText = TakoMixFeed("图片前", getResources().getIdentifier("ic_category_11", "mipmap", getPackageName()), 1001)

        datas.add(testTextImage)
        datas.add(testImageText)

        // init NimbleCard
        NimbleTemplatesLoader.initialize(mContext)
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST))
        //        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        myAdapter = NimbleAdapter(datas, mContext)
        mRecyclerView.adapter = myAdapter
        mRecyclerView.visibility = View.VISIBLE
    }
}
