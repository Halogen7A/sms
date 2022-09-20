package jpa.test.getsemail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jpa.entitymodels.Student;


public class TestGetStudentEmail {
	
	@Test
	public void getStudentEmail() {
		Student student = new Student();
		String expected = "halitosmanozgur@hotmail.com";
		student.setsEmail(expected);
		
		String actual = student.getsEmail();

		assertEquals(actual, expected);
		
	}
}
