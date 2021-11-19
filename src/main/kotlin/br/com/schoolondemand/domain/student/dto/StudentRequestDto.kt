package br.com.schoolondemand.domain.student.dto

import java.time.Instant
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class StudentRequestDto (
    @field: NotBlank
    val name: String,
    @field: NotBlank
    val cpf: String,
    @field: NotBlank
    @field: Email
    val email: String,
    @field: NotBlank
    val rg: String,
    @field: NotBlank
    val birthDate: String,
    @field: NotBlank
    val motherName: String,
    @field: NotBlank
    val fatherName: String,
)