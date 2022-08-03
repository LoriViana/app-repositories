package br.com.dio.app.repositories.data.domain

data class DetailCommit(
    val sha: String,
    val commit: CommitMessage,
    val author: AuthorCommit
    )
