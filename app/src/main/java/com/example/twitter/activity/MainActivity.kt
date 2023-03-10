package com.example.twitter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.adapter.FeedAdapter
import com.example.twitter.adapter.StoryAdapter
import com.example.twitter.databinding.ActivityMainBinding
import com.example.twitter.model.Post
import com.example.twitter.model.Story

class MainActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityMainBinding
    private lateinit var storyList: RecyclerView
    private lateinit var feedList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        supportActionBar!!.hide()

        storyList = binding.storyList
        feedList = binding.feedList

        storyList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        feedList.layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)

        val stories = ArrayList<Story>()
        val feeds = ArrayList<Post>()

        storyLoad(stories)
        feedLoad(feeds)

        val storyAdapter = StoryAdapter(stories)
        val feedAdapter = FeedAdapter(context, feeds)

        storyList.adapter = storyAdapter
        feedList.adapter = feedAdapter
    }

    private fun storyLoad(stories: ArrayList<Story>) {
        stories.add(Story(R.drawable.image1, "Ocean"))
        stories.add(Story(R.drawable.image2, "Alien"))
        stories.add(Story(R.drawable.image3, "Ibrohim"))
        stories.add(Story(R.drawable.image1, "Ocean"))
        stories.add(Story(R.drawable.image2, "Alien"))
        stories.add(Story(R.drawable.image3, "Ibrohim"))
        stories.add(Story(R.drawable.image1, "Ocean"))
        stories.add(Story(R.drawable.image2, "Alien"))
        stories.add(Story(R.drawable.image3, "Ibrohim"))
    }

    private fun feedLoad(feeds: ArrayList<Post>) {
        feeds.add(Post(R.drawable.image1, "Alien Ware", R.drawable.post1))
        feeds.add(Post(R.drawable.image2, "Khalilov Ibrohim", R.drawable.post2))
        feeds.add(Post(R.drawable.image3, "Alien Dev", R.drawable.post3))
        feeds.add(Post(R.drawable.image1, "Alien Ware", R.drawable.post1))
        feeds.add(Post(R.drawable.image2, "Khalilov Ibrohim", R.drawable.post2))
        feeds.add(Post(R.drawable.image3, "Alien Dev", R.drawable.post3))
    }
}
