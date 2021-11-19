package br.com.schoolondemand

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SchoolOnDemandApplication

fun main(args: Array<String>) {
	runApplication<SchoolOnDemandApplication>(*args)
}
