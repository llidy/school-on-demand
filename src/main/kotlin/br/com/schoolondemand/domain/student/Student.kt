package br.com.schoolondemand.domain.student

import java.time.Instant
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
    val Id: Long? = null,
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
    @field: NotNull
    val registrationNumber: Instant? = Instant.now(),
    @NotNull
    val initialDate: Instant? = Instant.now()

)