package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/students")
class StudentController(
    private val studentService: StudentService) {

    @GetMapping
    fun findAllByStudent(): List<StudentResponseDto> {
        return studentService.findAllByStudentGrouped()
    }

    @GetMapping("name/{name}")
    fun findByNameStudent(@PathVariable name: String
    ): List<StudentRequestDto>{
        return studentService.findByNameStudent(
            name)
    }

    @GetMapping("cpf/{cpf}")
    fun findByCpfStudent(@PathVariable cpf: String
    ): List<StudentRequestDto>{
        return studentService.findByCpfStudent(
            cpf)
    }

    @GetMapping("email/{email}")
    fun findByEmailStudent(@PathVariable email: String
    ): List<StudentRequestDto>{
        return studentService.findByEmailStudent(
            email)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registrationStudent(@RequestBody @Valid studentRequestDto: StudentRequestDto){
        return studentService.createRegistrationStudent(studentRequestDto)
    }
}