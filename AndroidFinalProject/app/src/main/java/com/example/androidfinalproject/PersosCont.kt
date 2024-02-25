package com.example.androidfinalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import Perso
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.imageview.ShapeableImageView

class ListAdapterPerso(private val persos: List<Perso>) :
    RecyclerView.Adapter<ListItemPerso>() {
    override fun getItemCount(): Int {
        return persos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemPerso {
        return ListItemPerso(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cardperso, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListItemPerso, position: Int) {
        val personnage = persos[position]
        holder.bindItem(personnage)
    }
}

class ListItemPerso(v: View) : RecyclerView.ViewHolder(v) {

    val img: ShapeableImageView = v.findViewById(R.id.ppPerso)
    val name: TextView = v.findViewById(R.id.nomPerso)

    fun bindItem(perso: Perso) {
        name.text = perso.name

        Glide.with(itemView).load(perso.img).into(img)
    }
}

class PersoFrag(val persos: List<Perso>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.persofragment,
            container,
            false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.listePerso).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapterPerso(persos)
        }
    }
}
