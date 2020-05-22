package com.kneipenrallye.kneipenrallye

import android.os.Bundle
import android.provider.AlarmClock
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_barlist.*
import okhttp3.*
import java.io.IOException


class barlist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barlist)

        recyclerView_barlist.layoutManager = LinearLayoutManager(this)
        //recyclerView_barlist.adapter = barlistAdapter()

        val message = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE)

        fetchJson()
    }

    fun fetchJson() {
        println("Try to fetch JSON")

        val url = "https://xtd.myqnapcloud.com:8443/bars.json"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_barlist.adapter = barlistAdapter(homeFeed)
                }
            }
        })
    }

}

// JSON FILE
//{
//    "bars":[
//    {
//        "id":1,
//        "name":"Mono",
//        "description":"def",
//        "link":""
//    }
//    ]
//}

class HomeFeed(val bars: List<Bars>)

class Bars(val id: Int, val name: String, val description: String, val link: String)