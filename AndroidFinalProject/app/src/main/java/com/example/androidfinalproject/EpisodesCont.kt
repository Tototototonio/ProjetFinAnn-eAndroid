package com.example.androidfinalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import Episode

class ListItemEpisode(v: View) : RecyclerView.ViewHolder(v) {

    val img: ImageView = v.findViewById(R.id.imgEpisode)
    val name: TextView = v.findViewById(R.id.titreEpisode)
    val number: TextView = v.findViewById(R.id.numéroEpisode)

    fun bindItem(episode: Episode) {
        name.text = episode.name
        number.text = "Episode #${episode.number}"
        Glide.with(itemView).load(episode.img).into(img)
    }

}

class ListAdapterEpisodes(private val episodes: List<Episode>) :
    RecyclerView.Adapter<ListItemEpisode>() {
    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemEpisode {
        return ListItemEpisode(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cardepisode, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListItemEpisode, position: Int) {
        val episode = episodes[position]
        holder.bindItem(episode)
    }
}

class EpisodeFrag(val episodes: List<Episode>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.episodes_fragment,
            container,
            false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.episodes_list).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapterEpisodes(episodes)
        }
    }
}
