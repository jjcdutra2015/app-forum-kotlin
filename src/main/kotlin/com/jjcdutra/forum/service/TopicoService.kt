package com.jjcdutra.forum.service

import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.dto.TopicoView
import com.jjcdutra.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    var topicos: List<Topico> = ArrayList(),
    val cursoService: CursoService,
    val autorService: UsuarioService
) {

    fun listar(): List<TopicoView> {
        return topicos.map {
            TopicoView(
                id = it.id,
                titulo = it.titulo,
                mensagem = it.mensagem,
                status = it.status,
                dataCriacao = it.dataCriacao
            )
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.first { it.id == id }
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(dto: NovoTopicoForm) {
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