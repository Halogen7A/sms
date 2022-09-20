package jpa.entitymodels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@NamedQueries({
	@NamedQuery(name = "GetAllStudents", query = "from Student"),
	@NamedQuery(name = "GetStudentByEmail", query = "from Student s where s.sEmail = :sEmail"),
	@NamedQuery(name = "GetStudentByEmailAndPassword", query = "from Student s where s.sEmail = :sEmail and s.sPassword = :sPassword")
	
	
})
public class Student {
	
	@Id
	@Column (name="email", unique=true, nullable=false, columnDefinition="VARCHAR(50)")
	private String sEmail;
	
	@Column (name= "name", columnDefinition="VARCHAR(50)")
	private String sName;
	
	@Column (name= "password", columnDefinition="VARCHAR(50)")
	private String sPassword;
	
	@ManyToMany(targetEntity = Course.class)
	private List<Course> sCourses;
	
	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPassword = "";
	}

	public Student(String sEmail, String sName, String sPassword, List<Course> sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sCourses = sCourses;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPassword=" + sPassword + ", sCourses=" + sCourses
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sCourses == null) {
			if (other.sCourses != null)
				return false;
		} else if (!sCourses.equals(other.sCourses))
			return false;
		if (sEmail == null) {
			if (other.sEmail != null)
				return false;
		} else if (!sEmail.equals(other.sEmail))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (sPassword == null) {
			if (other.sPassword != null)
				return false;
		} else if (!sPassword.equals(other.sPassword))
			return false;
		return true;
	}
	
	

	
	
}
