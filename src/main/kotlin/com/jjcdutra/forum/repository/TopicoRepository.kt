package com.jjcdutra.forum.repository

import com.jjcdutra.forum.dto.TopicoPorCategoriaDto
import com.jjcdutra.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {

    fun findByCursoNome(nomeCurso: String?, paginacao: Pageable): Page<Topico>

    @Query("SELECT new com.jjcdutra.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(*)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>
}