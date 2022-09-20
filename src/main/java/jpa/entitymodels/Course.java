package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@NamedQueries({
	@NamedQuery(name = "GetAllCourses", query = "from Course"),
	@NamedQuery(name = "GetCourseById", query = "from Course c where c.cId = :cId")
})
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "id")
	private int cId;
	
	@Column (name= "name", columnDefinition="VARCHAR(50)")
	private String cName;
	
	@Column (name= "Instructor", columnDefinition="VARCHAR(50)")
	private String cInstructorName;
	
	
	public Course() {
		this.cName = "";
		this.cInstructorName = "";
	}

	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}


	
	
	
}
