package com.kneipenrallye.kneipenrallye


class HomeFeed(val bars: List<Bars>)

class Bars(val id: Int, val name: String, val description: String, val img_preview: String, val img_bar: String, val location: String, val special: String)

// JSON FILE
//{
//    "id":0,
//    "name":"Bar 13",
//    "description":"Cocktailbar in Regensburg",
//    "link":"https://scontent-frt3-1.xx.fbcdn.net/v/t31.0-8/288034_10150269628051958_2785002_o.jpg?_nc_cat=106&_nc_sid=85a577&_nc_ohc=o76eBm7jfZMAX8jRuMv&_nc_ht=scontent-frt3-1.xx&oh=a0bfaac34b2c58df99564b725956c2ac&oe=5EEE9829",
//    "img_bar":"https://lh5.googleusercontent.com/p/AF1QipN52uwCrR_0zpYMn9uM3FctEVPXn-voIiOaTF2A=w408-h301-k-no",
//    "location":"Keplerstraße 13, 93047 Regensburg",
//    "special":"3x Shots 2\n1x Cocktail 4"
//},
