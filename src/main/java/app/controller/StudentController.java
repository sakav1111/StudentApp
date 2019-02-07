package app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Student;
import app.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository repository;


	//1.Create a new Student
	@PostMapping("/add")
	public Student createStudent(@Valid @RequestBody Student student) {
	    return repository.save(student);
	}	
	
	
	//1.Create a new Student
		@PostMapping("/addentity")
		public ResponseEntity<?> createStudentResponnse(@Valid @RequestBody Student student) {
		     repository.save(student);
		    return ResponseEntity.ok().build();
		}	
		
	
	
	@PostMapping("/update")
	public Student updateStudent(@Valid @RequestBody Student student) {
		Student st = repository.findById(student.getSno()).orElse(null);
		
		st.setName(student.getName());
		st.setCity(student.getCity());
		st.setMarks(student.getMarks());		
	    return repository.save(st);
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteStudent(@Valid @RequestBody Student student) {
	    repository.delete(student);
	    return ResponseEntity.ok().build();
	}
	
	@GetMapping("/get/{id}")
	public Student getById(@PathVariable(value = "id") Integer id) {		
	    return repository.findById(id).orElse(new Student());
	    
	    /* Optional<T> findById(ID id);  so return type is Optional, it is for prevent NullPointerException
	     * so we must say what should do if it returns null. So, we can use following ways
	     * 	1.return new object :  Foo foo = repository.findById(id).orElse(new Foo());
	     *  2.return null object :  Foo foo = repository.findById(id).orElse(null);
	     *  3.throw exception if null :  Foo foo = repository.findById(id)..orElseThrow(() -> new NotFoundEntity(id));
	     * */
	}

	// 4.Get All Students
	@GetMapping("/list")
	public List<Student> getAllStudents() {
		return repository.findAll();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable (value="id") Integer id) {		
		repository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
	
	

}
