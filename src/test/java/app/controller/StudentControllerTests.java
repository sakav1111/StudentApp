package app.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



 
public class StudentControllerTests {
	
	
	@Test
	public void testSum() {
		System.out.println("JUNIT: \n=============== \n StudentControllerTests \n \n");
		 int a=10; 
		 assertEquals(a, 10);
	}
	
/*
	@Test
	public void testCreateStudent() {
		 StudentController controller = new StudentController();
		 Student s =	 controller.createStudent(new Student(200, "RAMU", "HYDERABAD", 339));
		 assertEquals(s, s);
	}*/
	
	/* =========================
	 * OUTPUT is:java.lang.NullPointerException
	at app.controller.StudentController.createStudent(StudentController.java:33)
	at app.controller.StudentControllerTests.testCreateStudent(StudentControllerTests.java:25)
	 
	What is the problem
	----------------------------
	This is because we instantiated the StudentController and we didn't use Spring to inject it, and it  never got created properly by Spring.

	How To Solve
	------------------
	This is the exact problem that mock frameworks were created for. 
	By using Mockito, we can mock the StudentController so we can get our test to work:
	 


	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

}