package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Curso
import com.jjcdutra.forum.model.Topico
import com.jjcdutra.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    var topicos: List<Topico>
) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao"),
            autor = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com")
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Kotlin 2",
            mensagem = "Variaveis no Kotlin 2",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao"),
            autor = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com")
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvida Kotlin 3",
            mensagem = "Variaveis no Kotlin 3",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programacao"),
            autor = Usuario(id = 1, nome = "Ana da Silva", email = "ana@email.com")
        )

        topicos = listOf(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first { it.id == id }
    }
}