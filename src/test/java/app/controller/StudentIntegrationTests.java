package app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.Valid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.model.Student;
import app.repository.StudentRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StudentRepository repository;
	// StudentController has repository dependancy. So it will inject when it
	// required

	/*
	 * LIST : http://localhost:8080/api/list GET : http://localhost:8080/api/get/id
	 * ADD : http://localhost:8080/api/add UPDATE : http://localhost:8080/api/update
	 * DELETE : http://localhost:8080/api/delete DEL BY ID :
	 * http://localhost:8080/api/delete/id
	 */

	/*
	 * ==============================================*
	 * http://localhost:8080/api/list 
	 * ================================ output is
	 * Array of Student Objects 
	 * [
    {
        "sno": 101,
        "name": "Satya",
        "city": "Hyderabad",
        "marks": 508
    },
    {
        "sno": 102,
        "name": "Rahul",
        "city": "mumbao",
        "marks": 456
    },
    {
        "sno": 103,
        "name": "vikki",
        "city": "vizag",
        "marks": 332
    }
]
	 */

	/*
	 * ========================================= 
	 * GET TESTING
	 * ======================================= 
	 * // 4.Get All Students
	 * 
	 * @GetMapping("/list") 
	 * public List<Student> getAllStudents() { 
	 *       return repository.findAll(); 
	 *  }
	 */

	@Test
	public void getAllStudentsTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/list")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray()); // checks root of output is Array

		// .andExpect(MockMvcResultMatchers.jsonPath("$[].sno").isNumber());//checks
		// 'sno' of first object is number

		/*
		 * MockMvcRequestBuilders -hit the APIs & passing the path parameters and verify
		 * the status response codes MockMvcResultMatchers,MockMvcResultHandlers – get
		 * the response content & matches with expected content *
		 */
	}

	/*
	 * @GetMapping("/get/{id}")
	    public Student getById(@PathVariable(value = "id") Integer id) {		
	        return repository.findById(id).orElse(new Student());
	    }
	 */

	@Test
	public void getStudentByIdTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/api/get/{id}", 101)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.sno").value(0));
	}

	/*
	 * ============================== POST TESTING ==============================
	@PostMapping("/add")
	public Student createStudent(@Valid @RequestBody Student student) {
	    return repository.save(student);
	}	
	 */

	@Test
	public void createStudentTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/add")
				.content(toJsonUsingJackSon(new Student(201, "MANOJ", "VIZAG", 567)))
				// here we are converting Student object to json using JACKSON
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.sno").exists());
	}

	@Test
	public void createStudentResponnseTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/addentity")
				.content(toJsonUsingJackSon(new Student(201, "MANOJ", "VIZAG", 567)))
				// here we are converting Student object to json using JACKSON
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	public static String toJsonUsingJackSon(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * ================================= 
	 * DELETE TESTING
	 * ==============================
	 * 	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable (value="id") Integer id) {		
		repository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
	 */

	@Test
	public void deleteByIdTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.delete("api/delete/{id}", 101))
				.andExpect(status().isOk());

	}

}