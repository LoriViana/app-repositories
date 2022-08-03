package br.com.dio.app.repositories.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.app.repositories.data.services.GitHubCommitService
import br.com.dio.app.repositories.presentation.DetailCommitViewModel

class DetailCommitViewModelFactory constructor(private val repository: GitHubCommitService,
       private val user: String, private val repos:String): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailCommitViewModel::class.java)) {
            DetailCommitViewModel(this.repository,this.user,this.repos) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
