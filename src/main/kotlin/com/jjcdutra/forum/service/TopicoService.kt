package com.jjcdutra.forum.service

import com.jjcdutra.forum.dto.AtualizacaoTopicoForm
import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.dto.TopicoView
import com.jjcdutra.forum.exception.NotFoundException
import com.jjcdutra.forum.mapper.TopicoFormMapper
import com.jjcdutra.forum.mapper.TopicoViewMapper
import com.jjcdutra.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val repository: TopicoRepository,
    val topicoViewMapper: TopicoViewMapper,
    val topicoFormMapper: TopicoFormMapper,
) {
    private val notFoundMessage = "Tópico não encontrado!"

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if (nomeCurso.isNullOrEmpty()) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { topicoViewMapper.map(it) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findByIdOrNull(id) ?: throw NotFoundException(notFoundMessage)
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findByIdOrNull(form.id) ?: throw NotFoundException(notFoundMessage)
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}