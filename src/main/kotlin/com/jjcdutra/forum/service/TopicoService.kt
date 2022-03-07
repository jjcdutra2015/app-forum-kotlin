package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Curso
import com.jjcdutra.forum.model.Topico
import com.jjcdutra.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService {

    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao"),
            autor = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com")
        )
        return listOf(topico, topico, topico)
    }
}