package com.example.twitter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.databinding.ItemFeedStoryBinding
import com.example.twitter.model.Story

class StoryAdapter(private val stories: ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFeedStoryBinding.bind(view)
        val profile = binding.storyProfile
        val name = binding.storyName
    }

    private fun init(holder: StoryViewHolder, story: Story) {
        holder.profile.setImageResource(story.profile)
        holder.name.text = story.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryViewHolder) init(holder, stories[position])
    }

    override fun getItemCount(): Int {
        return stories.size
    }
}
