package com.jjcdutra.forum.mapper

import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.model.Topico
import com.jjcdutra.forum.service.CursoService
import com.jjcdutra.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    val cursoService: CursoService,
    val usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(form: NovoTopicoForm): Topico {
        return Topico(
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = cursoService.buscarPorId(form.idCurso),
            autor = usuarioService.buscarPorId(form.idAutor)
        )
    }

}
