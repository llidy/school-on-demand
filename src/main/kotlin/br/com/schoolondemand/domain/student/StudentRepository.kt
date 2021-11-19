package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
    abstract fun findByName(name: String): List<StudentRequestDto>
    abstract fun findByCpf(cpf: String): List<StudentRequestDto>
    abstract fun findByEmail(email: String): List<StudentRequestDto>


}