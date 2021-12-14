package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator


@Component
open class SingleField(val studentService: StudentService) : Validator {

    override fun supports(clazz: Class<*>): Boolean {
        return clazz.isAssignableFrom(StudentRequestDto::class.java)
    }

    override fun validate(target: Any, errors: Errors) {
        studentService.isExistsCpf(target, errors)
    }

}
