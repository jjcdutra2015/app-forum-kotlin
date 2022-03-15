package com.jjcdutra.forum.repository

import com.jjcdutra.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long>