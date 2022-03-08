package com.jjcdutra.forum.service

import com.jjcdutra.forum.dto.NovoTopicoDto
import com.jjcdutra.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    var topicos: List<Topico> = ArrayList(),
    val cursoService: CursoService,
    val autorService: UsuarioService
) {

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.first { it.id == id }
    }

    fun cadastrar(dto: NovoTopicoDto) {
        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = autorService.buscarPorId(dto.idAutor)
            )
        )
    }
}