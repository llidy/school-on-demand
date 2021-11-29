package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentPutDto
import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository: JpaRepository<Student, Long> {
    abstract fun findByName(name: String): List<StudentResponseDto>
    abstract fun findByCpf(cpf: String): List<StudentResponseDto,>
    abstract fun findByEmail(email: String): List<StudentResponseDto>


}