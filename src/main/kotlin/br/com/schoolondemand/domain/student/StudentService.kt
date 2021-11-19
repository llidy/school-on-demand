package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.stream.Collectors

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val students: List<Student> = ArrayList()
) {

    fun findAllByStudentGrouped(): List<StudentResponseDto> {
        return students.stream().map { t -> StudentResponseDto(
            name = t.name,
            cpf = t.cpf,
            email = t.email,
            rg = t.rg,
            birthDate = t.birthDate,
            motherName = t.motherName,
            fatherName = t.fatherName,
        ) }.collect(Collectors.toList())
    }

    fun findByNameStudent(name: String
    ): List<StudentRequestDto>{
        return studentRepository.findByName(
            name)
    }

    fun findByCpfStudent(cpf: String
    ): List<StudentRequestDto>{
        return studentRepository.findByCpf(
            cpf)
    }

    fun findByEmailStudent(email: String
    ): List<StudentRequestDto>{
        return studentRepository.findByEmail(
            email)
    }

    fun createRegistrationStudent(studentRequestDto: StudentRequestDto) {
        studentRepository.save(Student(

            name = studentRequestDto.name,
            cpf = studentRequestDto.cpf,
            email = studentRequestDto.email,
            rg = studentRequestDto.rg,
            birthDate = studentRequestDto.birthDate,
            motherName = studentRequestDto.motherName,
            fatherName = studentRequestDto.fatherName,

        ))
    }


}