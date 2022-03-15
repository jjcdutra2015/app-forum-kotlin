package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Curso
import com.jjcdutra.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository
) {

    fun buscarPorId(id: Long): Curso {
        return repository.getById(id)
    }
}
