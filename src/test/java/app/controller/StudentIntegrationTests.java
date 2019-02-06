package app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class) 
public class StudentIntegrationTests {
	 
	@Autowired
	 private MockMvc mvc; 
	
	
	/*=========================================
	 * 	// 4.Get All Students
	@GetMapping("/list")
	public List<Student> getAllStudents() {
		return repository.findAll();
	}
	 ==============================================* 
	 * */
	
	
	/*
	@Test
	public void getAllStudentsTest() throws Exception{
		
		mvc.perform( MockMvcRequestBuilders
			      .get("/list")
			      .accept(MediaType.APPLICATION_JSON))			      
			      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
		
		
	}
	*/
	
}