package com.jjcdutra.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty(message = "Título não pode ser em branco")
    @field:Size(min = 5, max = 100, message = "Titulo deve conter entre 5 e 100 caracteres")
    val titulo: String,
    @field:NotEmpty(message = "Mensagem não pode ser em branco")
    val mensagem: String
)