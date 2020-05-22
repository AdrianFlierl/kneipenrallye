package com.kneipenrallye.kneipenrallye


class HomeFeed(val bars: List<Bars>)

class Bars(val id: Int, val name: String, val description: String, val link: String)

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
