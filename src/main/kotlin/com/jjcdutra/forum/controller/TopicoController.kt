package com.jjcdutra.forum.controller

import com.jjcdutra.forum.dto.NovoTopicoForm
import com.jjcdutra.forum.dto.TopicoView
import com.jjcdutra.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody dto: NovoTopicoForm) {
        service.cadastrar(dto)
    }
}