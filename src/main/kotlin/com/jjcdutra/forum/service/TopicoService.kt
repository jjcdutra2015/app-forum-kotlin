package com.jjcdutra.forum.service

import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.dto.TopicoView
import com.jjcdutra.forum.mapper.TopicoFormMapper
import com.jjcdutra.forum.mapper.TopicoViewMapper
import com.jjcdutra.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    var topicos: List<Topico> = ArrayList(),
    val topicoViewMapper: TopicoViewMapper,
    val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.map { topicoViewMapper.map(it) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.first { it.id == id }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}