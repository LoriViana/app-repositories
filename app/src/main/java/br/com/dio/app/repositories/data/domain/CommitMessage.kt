package br.com.dio.app.repositories.data.domain

data class CommitMessage(
    val author: CommitAuthor,
    val message: String,
 )
