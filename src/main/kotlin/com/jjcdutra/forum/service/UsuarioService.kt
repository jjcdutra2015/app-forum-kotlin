package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Usuario
import com.jjcdutra.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) : UserDetailsService {

    fun buscarPorId(idAutor: Long): Usuario {
        return repository.getById(idAutor)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }
}
