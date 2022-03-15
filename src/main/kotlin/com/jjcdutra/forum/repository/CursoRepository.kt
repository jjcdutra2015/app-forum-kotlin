package com.jjcdutra.forum.repository

import com.jjcdutra.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long>