package br.com.dio.app.repositories.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.dio.app.repositories.data.services.GitHubCommitService
import br.com.dio.app.repositories.databinding.ActivityDetailCommitBinding
import br.com.dio.app.repositories.presentation.DetailCommitViewModel
import br.com.dio.app.repositories.presentation.di.DetailCommitViewModelFactory
import com.bumptech.glide.Glide


class DetailCommitActivity : AppCompatActivity() {

    lateinit var detailCommitViewModel: DetailCommitViewModel
    lateinit var viewModel: DetailCommitViewModel
    private val gitHubCommitService = GitHubCommitService.getInstance()
    private  val adapter = DetailCommitAdapter()
    private val binding by lazy { ActivityDetailCommitBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        inicializaViewModel()
        binding.rvDetailcommit.setHasFixedSize(true)
        binding.rvDetailcommit.adapter =adapter
    }

    private fun inicializaViewModel() {
       val user= intent.getStringExtra("USER")
       val rep= intent.getStringExtra("REPOSITORIO")
       val link = intent. getStringExtra("LINK")


        if (user != null)
        { if (rep != null){
            if(link != null){
                viewModel = ViewModelProvider(this,DetailCommitViewModelFactory(gitHubCommitService,user ,rep)).get(DetailCommitViewModel::class.java)

            }
        }
  }
 }

    override fun onStart() {
        super.onStart()

      viewModel.itemList.observe(this, Observer{
            Log.d("TAG","onCreate: $it")
         adapter.setDetailCommit(it)
          binding.tvlogin.text = it.get(1).author.login
          var imagem= it.get(1).author.avatar_url

          Glide.with(this).load(imagem).circleCrop().into(binding.ivUser)
        })
        binding.btnVoltar.setOnClickListener{
            finish()
        }
        viewModel.errorMessage.observe(this, Observer{

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllCommits()


    }

}