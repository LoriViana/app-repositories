package br.com.dio.app.repositories.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dio.app.repositories.data.domain.DetailCommit
import br.com.dio.app.repositories.data.services.GitHubCommitService
import kotlinx.coroutines.flow.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCommitViewModel constructor(private val repository: GitHubCommitService, private val user: String, private val repos:String) :

   ViewModel() {


    val itemList = MutableLiveData<List<DetailCommit>>()
    val errorMessage = MutableLiveData<String>()

  fun getAllCommits() {
      var response = repository.getAllCommits(user, repos)

      Log.i("DADOSMODEL", "$user + $repos + ${response.toString()}")

        response.enqueue(object : Callback<List<DetailCommit>>{
            override fun onResponse(
                call: Call<List<DetailCommit>>,
                response: Response<List<DetailCommit>>
            ) {
              itemList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<DetailCommit>>, t: Throwable) {
             errorMessage.postValue(t.message)
            }
        })
  }
 }




