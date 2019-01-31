package bootcamp.project.helper;

import java.util.ArrayList;
import java.util.List;

public class StudentsAndGradesList {
	
		public List<gradesHelper> studentsAndGradesList;

		
		public StudentsAndGradesList(List<gradesHelper>studentsAndGradesList) {
			super();
			this.studentsAndGradesList = studentsAndGradesList;
		}
		
		public List<gradesHelper> getStudentsAndGradesList() {
			return studentsAndGradesList;
		}

		public void setListOfInfoForView(List<gradesHelper> studentsAndGradesList) {
			this.studentsAndGradesList = studentsAndGradesList;
		}

		public StudentsAndGradesList() {
			super();
			this.studentsAndGradesList = new ArrayList<>();
		}
		
		public void addNewItem(gradesHelper data)
		{
			this.studentsAndGradesList.add(data);
		}

		@Override
		public String toString() {
			return "StudentsAndGradesList [allDataForSetGradeView=" + studentsAndGradesList + "]";
		}
		
		

	}
