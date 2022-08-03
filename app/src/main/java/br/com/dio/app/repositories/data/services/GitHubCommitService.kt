package br.com.dio.app.repositories.data.services

import br.com.dio.app.repositories.data.domain.DetailCommit
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubCommitService {

    @GET("{user}/{repo}/commits")
  fun getAllCommits(@Path("user") user:String, @Path("repo") repo: String): Call<List<DetailCommit>>


    companion object {

        private val gitHubCommitService: GitHubCommitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/repos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(GitHubCommitService::class.java)
        }

        fun getInstance(): GitHubCommitService {
            return gitHubCommitService
        }
    }

}
