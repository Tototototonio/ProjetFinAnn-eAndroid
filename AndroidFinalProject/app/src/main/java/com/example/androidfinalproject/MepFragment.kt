package com.example.androidfinalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

class MepFragment : Fragment() {
    private lateinit var date: TextView
    private lateinit var retour: TextView
    private lateinit var backgroundImg: ImageView
    private lateinit var img: ImageView
    private lateinit var fragHistoire: TextView
    private lateinit var fragPerso: TextView
    private lateinit var fragEpisode: TextView
    private lateinit var numEpisode: TextView
    private lateinit var typeProducteur: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.misepage,
            container,
            false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fpv = MepFragmentArgs.fromBundle(requireArguments()).test

        date = view.findViewById<TextView>(R.id.Date)
        retour = view.findViewById<TextView>(R.id.Retour)
        backgroundImg = view.findViewById<ImageView>(R.id.Img)
        img = view.findViewById<ImageView>(R.id.Affiche)
        fragHistoire = view.findViewById<TextView>(R.id.HistoireFragment)
        fragPerso = view.findViewById<TextView>(R.id.PersonnnageFragment)
        fragEpisode = view.findViewById<TextView>(R.id.EpisodeFragment)
        numEpisode = view.findViewById<TextView>(R.id.NuméroEpisode)
        typeProducteur = view.findViewById<TextView>(R.id.MaisonEdit)
        date.text = fpv.année.toString()
        numEpisode.text = "${fpv.episodes.size} épisodes"
        typeProducteur.text = fpv.producteur
        retour.text = fpv.titre

        Glide.with(this).load("https://comicvine.gamespot.com/a/uploads/original/6/67663/6678758-6399865442-PAyOXD97w4txFMdr4_Jg0h-OkSmoyPs2uw5B9Tf0GWRysfUemPfeneFwSuEcnTrgzdg%3Ds2000").into(backgroundImg)
        Glide.with(this).load(fpv.img).into(img)

        childFragmentManager.beginTransaction()
            .replace(R.id.containerpage, HistoireCont(fpv))
            .commitAllowingStateLoss()

        fragPerso.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerpage, PersoFrag(fpv.persos))
                .commitAllowingStateLoss()
        }

        fragHistoire.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerpage, HistoireCont(fpv))
                .commitAllowingStateLoss()
        }

        fragEpisode.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerpage, EpisodeFrag(fpv.episodes))
                .commitAllowingStateLoss()
        }

        val backButton = view.findViewById<View>(R.id.retour)

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
