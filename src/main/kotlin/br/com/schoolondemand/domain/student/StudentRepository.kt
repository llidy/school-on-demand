package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long> {

    fun findByName(name: String): List<StudentResponseDto>
    fun findByCpf(cpf: String): List<StudentResponseDto,>
    fun findByEmail(email: String): List<StudentResponseDto>
    fun existsByCpf(cpf: String): Boolean
}
