package br.com.schoolondemand.domain.student.dto

import br.com.schoolondemand.domain.student.Student

data class StudentResponseDto (

    val id: Long? = null,
    val name: String = "",
    val cpf: String = "",
    val email: String = "",
    val rg: String = "",
    val birthDate: String = "",
    val motherName: String = "",
    val fatherName: String = "",
    val registrationNumber: String = ""

) {
    fun convertResponseToStudent(): Student {
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

    fun studentConvertToResponse(student: Student): StudentResponseDto{
        return StudentResponseDto(
            id = student.id,
            name = student.name,
            cpf = student.cpf,
            email = student.email,
            rg = student.rg,
            birthDate = student.birthDate,
            motherName = student.motherName,
            fatherName = student.fatherName ,
            registrationNumber = student.registrationNumber

        )
    }
}