package br.com.schoolondemand.domain.student.dto

import br.com.schoolondemand.domain.student.Student
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

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
){
    fun convertRequestDtoToStudent(): Student {
        return Student(
            name = name,
            cpf = cpf,
            email = email,
            rg = rg,
            birthDate = birthDate,
            motherName = motherName,
            fatherName = fatherName

        )
    }
}