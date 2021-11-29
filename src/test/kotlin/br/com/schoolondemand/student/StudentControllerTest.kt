package br.com.schoolondemand.student

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest() {

   @Autowired lateinit var mockMvc: MockMvc

    @Test
    fun saveNewStudent(){
      mockMvc.perform(MockMvcRequestBuilders.get("/students"))
             .andExpect(MockMvcResultMatchers.status().isOk)
             .andDo(MockMvcResultHandlers.print())
    }

}