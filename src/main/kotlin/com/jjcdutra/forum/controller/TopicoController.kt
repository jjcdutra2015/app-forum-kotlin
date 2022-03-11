package com.jjcdutra.forum.controller

import com.jjcdutra.forum.dto.AtualizacaoTopicoForm
import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.dto.TopicoView
import com.jjcdutra.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: NovoTopicoForm) {
        service.cadastrar(form)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm) {
        service.atualizar(form)
    }
}