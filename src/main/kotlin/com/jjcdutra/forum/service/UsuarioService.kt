package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Usuario
import com.jjcdutra.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) {

    fun buscarPorId(idAutor: Long): Usuario {
        return repository.getById(idAutor)
    }
}
