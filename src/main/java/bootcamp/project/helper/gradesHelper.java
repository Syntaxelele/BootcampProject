package bootcamp.project.helper;

public class gradesHelper {

		private String studentName;
		private String studentLastname;
		private int grade;
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public String getStudentSurname() {
			return studentLastname;
		}
		public void setStudentSurname(String studentSurname) {
			this.studentLastname = studentSurname;
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
			return "InfoForView [studentName=" + studentName + ", studentLastname=" + studentLastname + ", grade=" + grade + "]";
		}
		
	
	}


