package app.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import app.model.Student;
import app.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerMockitoTests {

//1.create Dependent mock Objects	
	@Mock
	private StudentRepository repository;

//2.Create & inject mock objects into controller object
	@InjectMocks
	private StudentController controller;

//3.Initilaize Mokito & Cretae all Mock objecs 
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetById() {
		System.out.println("MOCKS: \n=============== \n StudentControllerMocks \n \n");

		Optional<Student> student = Optional.of(new Student(101, "RAJU", "HYD", 412));

		//Controller inside calls repository.findById. so, if controller calls that it will return dummy object with data
		when(repository.findById(101)).thenReturn(student);

		Student student2 = controller.getById(101);
		
		//checking findById method of repository has same type of argument
		verify(repository).findById(101);
		assertEquals(101, student2.getSno());
	}

}