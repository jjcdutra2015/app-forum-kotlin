package com.jjcdutra.forum.repository

import com.jjcdutra.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long>