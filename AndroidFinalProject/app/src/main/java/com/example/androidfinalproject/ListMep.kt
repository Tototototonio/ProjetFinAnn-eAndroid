import com.example.androidfinalproject.R

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListMep : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.meplist,
            container,
            false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mepList = createSeriesList()

        view.findViewById<RecyclerView>(R.id.listMep).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter(mepList, object : OnItemClickListener {
                override fun onItemClicked(test: Test) {
                    // TODO
                     findNavController().navigate(
                         ListMepDirections.actionShowListToShowDetail(test)
                     )
                }
            })
        }
    }
}

class ListAdapter(private val Data: List<Test>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ListItem>() {

    override fun getItemCount(): Int {
        return Data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItem {
        return ListItem(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.mep, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListItem, position: Int) {
        val MEP = Data[position]
        holder.bindItem(MEP, position + 1)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(MEP)
        }
    }
}

class ListItem(v: View) : RecyclerView.ViewHolder(v) {

    val classement: TextView = v.findViewById(R.id.classementserie)
    val titre: TextView = v.findViewById(R.id.titreSerie)
    val episodes: TextView = v.findViewById(R.id.episodeSerie)
    val producteur: TextView = v.findViewById(R.id.producteurSerie)
    val date: TextView = v.findViewById(R.id.AnciennetéSerie)
    val img: ImageView = v.findViewById(R.id.imageSerie)

    fun bindItem(test: Test, position: Int) {
        this.classement.text = "#$position"
        titre.text = test.titre
        episodes.text = "${test.episodes.size} épisodes"
        producteur.text = test.producteur
        date.text = test.année.toString()

        Glide.with(itemView).load(test.img).into(img)
    }
}

interface OnItemClickListener {
    fun onItemClicked(test: Test)
}