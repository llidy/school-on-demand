package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentPutDto
import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import br.com.schoolondemand.domain.student.dto.StudentResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun findAllStudents(studentResponseDto: StudentResponseDto
    ) = studentService.findAllStudents(studentResponseDto)


    @GetMapping("name/{name}")
    fun findByNameStudent(@PathVariable name: String
    ) = studentService.findByNameStudent(
            name)

    @GetMapping("cpf/{cpf}")
    fun findByCpfStudent(@PathVariable cpf: String
    ) = studentService.findByCpfStudent(
            cpf)

    @GetMapping("email/{email}")
    fun findByEmailStudent(@PathVariable email: String
    ) = studentService.findByEmailStudent(
            email)

    @GetMapping("/{id}")
    fun findByIdStudent(@PathVariable id: Long
    ) = studentService.findByIdStudent(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createRegistrationStudent(
        @RequestBody @Valid studentRequestDto: StudentRequestDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<StudentResponseDto> {
        val studentResponseDto = studentService.createRegistrationStudent(studentRequestDto)
        val uri = uriBuilder.path("/students/${studentResponseDto.id}").build().toUri()
        return ResponseEntity.created(uri).body(studentResponseDto)
    }
    @InitBinder("studentRequestDto")
    fun binder(binder: WebDataBinder){
        binder.addValidators(SingleField(studentService))
    }

    @PutMapping("/{id}")
    fun updateRegistrationStudent(@PathVariable id: Long, @RequestBody studentPutDto: StudentPutDto
    ): ResponseEntity<StudentResponseDto>{
        val studentResponseDto = studentService.updateRegistrationStudent(id, studentPutDto)
        return ResponseEntity.ok(studentResponseDto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteRegistrationStudent(@PathVariable id: Long
    ) = studentService.deleteRegistrationStudent(id)

}