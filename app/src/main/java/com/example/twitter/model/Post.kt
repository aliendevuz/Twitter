package com.example.twitter.model

class Post {
    var profile: Int
    var name: String
    lateinit var photos: IntArray
    var video = ""

    constructor(profile: Int, name: String, photos: IntArray) {
        this.profile = profile
        this.name = name
        this.photos = photos
    }

    constructor(profile: Int, name: String, video: String) {
        this.profile = profile
        this.name = name
        this.video = video
    }
}

