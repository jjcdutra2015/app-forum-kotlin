package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    var topicos: List<Topico> = ArrayList()
) {

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first { it.id == id }
    }

    fun cadastrar(topico: Topico) {
        topicos.plus(topico)
    }
}