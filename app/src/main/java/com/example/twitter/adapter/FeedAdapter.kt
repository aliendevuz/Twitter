package com.example.twitter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.databinding.ItemFeedPostBinding
import com.example.twitter.model.Post

class FeedAdapter(private val context: Context, private val feeds: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFeedPostBinding.bind(view)
        val postProfile = binding.postProfile
        val postName = binding.postName
        val postImage = binding.postImage
    }

    private fun init(holder: FeedViewHolder, post: Post) {
        holder.postProfile.setImageResource(post.profile)
        holder.postName.text = post.name
        holder.postImage.setImageResource(post.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FeedViewHolder) init(holder, feeds[position])
    }

    override fun getItemCount(): Int {
        return feeds.size
    }
}
