package com.jjcdutra.forum.service

import com.jjcdutra.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario>
) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com.br"
        )

        usuarios = listOf(usuario)
    }

    fun buscarPorId(idAutor: Long): Usuario {
        return usuarios.first { it.id == idAutor }
    }
}
