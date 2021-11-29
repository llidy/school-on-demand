package br.com.schoolondemand.domain.student.dto

import br.com.schoolondemand.domain.student.Student

data class StudentPutDto (

    var name: String,
    val cpf: String,
    val email: String,
    val rg: String,
    val birthDate: String,
    val motherName: String,
    val fatherName: String
)
{
    fun convertToStudent(): Student {
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