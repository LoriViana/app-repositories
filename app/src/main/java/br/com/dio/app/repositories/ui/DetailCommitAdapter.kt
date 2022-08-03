package br.com.dio.app.repositories.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.app.repositories.data.domain.DetailCommit
import br.com.dio.app.repositories.databinding.ItemCommitMessageBinding

class DetailCommitAdapter :  RecyclerView.Adapter<MainViewHolder>(){

    private var detailCommit= mutableListOf<DetailCommit>()

    fun setDetailCommit (detailCommitToSet: List<DetailCommit>){
        this.detailCommit = detailCommitToSet.toMutableList()

        Log.e("LISTA","$detailCommit.toString()")
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCommitMessageBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(detailCommit[position])
    }

    override fun getItemCount(): Int = detailCommit.size

}


 class MainViewHolder(val binding: ItemCommitMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailCommit: DetailCommit){
            var data= detailCommit.commit.author.date
            binding.tvCommit.text = detailCommit.commit.message
            binding.tvDescricao.text = "Commit realizado em : $data"

        }




 }




//    fun bind(live: Live, onItemClicked: (Live) -> Unit) {
//
//        binding.title.text = live.title
//        binding.author.text = live.author
//
//        val requestOptions = RequestOptions()
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//
//        Glide.with(itemView.context)
//            .applyDefaultRequestOptions(requestOptions)
//            .load(live.thumbnailUrl)
//            .into(binding.thumbnail)
//
//        itemView.setOnClickListener {
//            onItemClicked(live)
//        }
//
//    }:



//
//class MainAdapter(private val onItemClicked: (Live) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {
//
//    private var lives = mutableListOf<Live>()
//
//    fun setLiveList(lives: List<Live>) {
//
//        this.lives = lives.toMutableList()
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ResItemLiveBinding.inflate(inflater, parent, false)
//        return MainViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        val live = lives[position]
//        holder.bind(live, onItemClicked)
//    }
//
//    override fun getItemCount(): Int {
//        return lives.size
//    }
//}
////
//class MainViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(live: Live, onItemClicked: (Live) -> Unit) {
//
//        binding.title.text = live.title
//        binding.author.text = live.author
//
//        val requestOptions = RequestOptions()
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//
//        Glide.with(itemView.context)
//            .applyDefaultRequestOptions(requestOptions)
//            .load(live.thumbnailUrl)
//            .into(binding.thumbnail)
//
//        itemView.setOnClickListener {
//            onItemClicked(live)
//        }
//
//    }:
