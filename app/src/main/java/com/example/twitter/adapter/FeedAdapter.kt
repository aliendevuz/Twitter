package com.example.twitter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.databinding.ItemFeedPostDoubleBinding
import com.example.twitter.databinding.ItemFeedPostSingleBinding
import com.example.twitter.model.ObjectType
import com.example.twitter.model.Post

class FeedAdapter(private var feeds: ArrayList<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class SingleFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding = ItemFeedPostSingleBinding.bind(view)
        var feedProfile = binding.postProfile
        var feedName = binding.postName
        var feedImage = binding.postImage
    }

    class DoubleFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding = ItemFeedPostDoubleBinding.bind(view)
        var feedProfile = binding.postProfile
        var feedName = binding.postName
        var feedImage1 = binding.postImage1
        var feedImage2 = binding.postImage2
    }

    private fun singleInit(holder: SingleFeedViewHolder, post: Post) {
        holder.feedProfile.setImageResource(post.profile)
        holder.feedName.text = post.name
        holder.feedImage.setImageResource(post.photos[0])
    }

    private fun doubleInit(holder: DoubleFeedViewHolder, post: Post) {
        holder.feedProfile.setImageResource(post.profile)
        holder.feedName.text = post.name
        holder.feedImage1.setImageResource(post.photos[0])
        holder.feedImage2.setImageResource(post.photos[1])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ObjectType.singleImage)
            SingleFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_single, parent, false))
        else
            DoubleFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_double, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SingleFeedViewHolder) singleInit(holder, feeds[position])
        if (holder is DoubleFeedViewHolder) doubleInit(holder, feeds[position])
    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (feeds[position].photos.size > 1) ObjectType.doubleImage else ObjectType.singleImage
    }
}
