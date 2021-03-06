package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @field: NotBlank
    var name: String,
    @field: NotBlank
    var cpf: String,
    @field: NotBlank
    @field: Email
    var email: String,
    @field: NotBlank
    var rg: String,
    @field: NotBlank
    var birthDate: String,
    @field: NotBlank
    var motherName: String,
    @field: NotBlank
    var fatherName: String,
    @field: NotNull
    val registrationNumber: String = generateRegistration(),
    @NotNull
    val initialDate: Instant = Instant.now()

) {

    fun updateStudent(student: Student) {
        name = student.name
        cpf = student.cpf
        email = student.email
        rg = student.rg
        birthDate = student.birthDate
        motherName = student.motherName
        fatherName = student.motherName
    }
}
    fun generateRegistration(): String{
        var date: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        var instant: String = Instant.now().nano.toString().substring(0,6)
        return "${date}${instant}"
    }