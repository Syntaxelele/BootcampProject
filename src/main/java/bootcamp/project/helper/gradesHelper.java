package bootcamp.project.helper;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import bootcamp.project.courses.Course;

public class gradesHelper {

		private String studentName;
		private String studentLastname;
		@Min(1)@Max(10)
		private int grade;
		
		private String courseName;
		
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getStudentLastname() {
			return studentLastname;
		}
		public void setStudentLastname(String studentLastname) {
			this.studentLastname = studentLastname;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;	
		}
			
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public gradesHelper(String studentName, String studentLastname, int grade, String courseName) {
			super();
			this.studentName = studentName;
			this.studentLastname = studentLastname;
			this.grade = grade;
			this.courseName = courseName;
		}
		
		public gradesHelper(String studentName, String studentLastname, int grade) {
			super();
			this.studentName = studentName;
			this.studentLastname = studentLastname;
			this.grade = grade;
		}
			
		
		public gradesHelper() {
		}

		@Override
		public String toString() {
			return "setGradesView [studentName=" + studentName
					+ ", studentLastname=" + studentLastname
					+ ", grade=" + grade + ", courseName=" + courseName
					+ "]";
		}
		
	
	}


