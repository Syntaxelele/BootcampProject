package bootcamp.project.helper;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class gradesHelper {

		private String studentName;
		private String studentLastname;
		@Min(1)@Max(10)
		private int grade;
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
					+ ", grade=" + grade
					+ "]";
		}
		
	
	}


