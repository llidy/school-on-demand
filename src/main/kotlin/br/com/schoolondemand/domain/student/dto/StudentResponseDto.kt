package br.com.schoolondemand.domain.student.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class StudentResponseDto (
    val name: String,
    val cpf: String,
    val email: String,
    val rg: String,
    val birthDate: String,
    val motherName: String,
    val fatherName: String

)