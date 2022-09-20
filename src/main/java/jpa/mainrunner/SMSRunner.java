package jpa.mainrunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jpa.dao.AbstractDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner extends AbstractDAO{
	
	SessionFactory factory = super.getFactory();
	Session session = super.getSession();
	
	private Scanner input;
	private StudentService studentService;
	private CourseService courseService;
	private String email;
	
	public SMSRunner() {
		input = new Scanner(System.in);
		studentService = new StudentService();
		courseService = new CourseService();
	}
	
	private int menu() {
		System.out.print("1. Student Login\n2. Quit\nPlease Enter Selection: ");
		int result = input.nextInt();
		input.nextLine();
		return result;
	}
	
	private boolean studentLogin() {
		boolean retValue = false;
		
		System.out.println("Enter your email address: ");
		email = input.next();
		System.out.println("Enter your password: ");
		String password = input.next();
		
		if(studentService.validateStudent(email, password)) {
			retValue = true;
		}
		
		else {
			System.out.println("Invalid user, please check your credentials.");
		}
		
		return retValue;
		
	}
	
	public void registerMenu() {
		System.out.print("1. Register a Class\n2. Quit\nPlease Enter Selection: ");
		int result = input.nextInt();
		input.nextLine();
		
		switch(result) {
			case 1:
				List<Course> studentCourses = studentService.getStudentCourses(email);
				List<Course> allCourses = courseService.getAllCourses();
				List<Integer> idList = new ArrayList<Integer>();
				System.out.printf("%5s%15s%15s\n\n", "ID", "Course", "Instructor");
				for(Course course : allCourses) {
					System.out.println(course);
					idList.add(course.getcId());
				}
				
				
				System.out.println("Enter Course Number");
				int courseNumber = input.nextInt();
				input.nextLine();
				
				if(idList.contains(courseNumber)) {
					studentService.registerStudentToCourse(email, courseNumber);
					
					System.out.println("My Classes");
					for(Course course : studentCourses) {
						System.out.println(course);
					}
				}
				
				else {
					System.out.println("Please select an existing course!");
				}
				
				break;
			case 2:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Quitting Application...");
		}
	}
	
	public void run(){
		switch(menu()) {
			case 1:
				if(studentLogin()) {
					registerMenu();
					System.out.println("Quitting Application...");
				}
				break;
			case 2:
				factory.close();
				session.close();
				System.out.println("Bye!");
				break;
			default:
				factory.close();
				session.close();
				System.out.println("Quitting Application...");
				
		}
	}
}
