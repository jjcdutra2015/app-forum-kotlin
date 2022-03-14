package com.jjcdutra.forum.model

import javax.persistence.Entity

@Entity
data class Curso(
    val id: Long? = null,
    val nome: String,
    val categoria: String
)
