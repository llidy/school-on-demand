package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentPutDto
import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class StudentService(
    private val studentRepository: StudentRepository,
    ) {

    fun findAllStudents(studentResponseDto: StudentResponseDto):List<StudentResponseDto> =
        studentRepository.findAll().stream().map { t ->
            StudentResponseDto(
                name = t.name,
                cpf = t.cpf,
                email = t.email,
                rg = t.rg,
                birthDate = t.birthDate,
                motherName = t.motherName,
                fatherName = t.fatherName
            )}.collect(Collectors.toList())

    fun findByNameStudent(name: String) =
        studentRepository.findByName(name)

    fun findByCpfStudent(cpf: String) =
        studentRepository.findByCpf(cpf)

    fun findByEmailStudent(email: String) =
        studentRepository.findByEmail(email)

    fun findByIdStudent(id: Long) =
        studentRepository.findById(id)

    fun createRegistrationStudent(studentRequestDto: StudentRequestDto): StudentResponseDto {
        val student = studentRepository.save(studentRequestDto.convertRequestDtoToStudent())
        return StudentResponseDto().studentConvertToResponse(student)
    }
    fun updateRegistrationStudent(id: Long, studentPutDto: StudentPutDto): StudentResponseDto {
        val student = studentRepository.findById(id).get()
        val studentUpdate = student.updateStudent(studentPutDto.convertToStudent())
        studentRepository.save(student)
        return StudentResponseDto().studentConvertToResponse(student)

    }

    fun deleteRegistrationStudent(id: Long) {
        val student = studentRepository.findById(id).get()
        studentRepository.delete(student)
    }

}