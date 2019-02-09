package app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Student;
import app.model.StudentMongo;
import app.repository.StudentMongoRepository;

@RestController
@RequestMapping("/mongo")
public class StudentMongoController {

	@Autowired
	StudentMongoRepository mongoRepository;

	// 1.Getting all users
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<StudentMongo> getAllStudents() {
		System.out.print("Getting all users.");
		return mongoRepository.findAll();
	}

	@RequestMapping(value = "/get/{sno}", method = RequestMethod.GET)
	public StudentMongo getStudent(@PathVariable int sno) {
		System.out.print("Getting user with ID: {}." + sno);
		return mongoRepository.findBySno(sno);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public StudentMongo addNewStudent(@RequestBody StudentMongo student) {
		return mongoRepository.save(student);
	}

	
	@PostMapping("/update")
	public StudentMongo updateStudent(@RequestBody StudentMongo student) {
		
		System.out.println("======= UPDATE : "+student.getSno());
		
		StudentMongo st = mongoRepository.findBySno(student.getSno());
		System.out.println("======= UPDATE :2 ");
		
		st.setName(student.getName());
		st.setCity(student.getCity());
		st.setMarks(student.getMarks());		
	    return mongoRepository.save(st);
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteStudent(@RequestBody StudentMongo student) {
		System.out.println("======= deleted........... :2 ");
		mongoRepository.delete(student);
	    return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/deleteByName")
	public ResponseEntity<?> deleteStudentByName(@RequestBody StudentMongo student) {
		System.out.println("======= deleteByName........... :2 ");
		mongoRepository.deleteByName(student.getName());
	    return ResponseEntity.ok().build();
	}
	
	
	
}