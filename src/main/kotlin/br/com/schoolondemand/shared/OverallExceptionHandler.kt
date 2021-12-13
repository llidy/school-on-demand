package br.com.schoolondemand.shared

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class OverallExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(ex: MethodArgumentNotValidException): ResponseEntity<Any>{

        val errors = mutableListOf<Map<String, String?>>()

        for (fieldErro in ex.fieldErrors){
            errors.add(mapOf(Pair(fieldErro.field, fieldErro.defaultMessage)))
        }

        return ResponseEntity.badRequest().body(errors)
    }
}