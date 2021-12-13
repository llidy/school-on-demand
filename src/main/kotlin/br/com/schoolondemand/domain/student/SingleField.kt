package br.com.schoolondemand.domain.student

import br.com.schoolondemand.domain.student.dto.StudentRequestDto
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder

class SingleField(val studentRepository: StudentRepository) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return clazz.isAssignableFrom(StudentRequestDto::class.java)
    }

    override fun validate(target: Any, errors: Errors) {
        val student = target as StudentRequestDto

        if (studentRepository.existsByCpf(student.cpf))
           errors.rejectValue("cpf", "cpf.jaCadastrado", "cpf ja cadastrado")
    }


}
