package bootcamp.project;
//----------------------------IMPORTS----------------------------------//

import bootcamp.project.courses.Course;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//---------------------------------------------------------------------//

public class testCourses {
    @Test
    public void testDefaultInput() {
        Course CT1 = new Course();

        assertEquals("", CT1.getTitle());
        assertEquals("", CT1.getDescription());
        assertEquals(0, CT1.getProfessor());
        assertEquals("", CT1.getCourseCode());
        assertEquals("", CT1.getEvaluation());
        assertEquals(0, CT1.getCP());
        assertEquals("", CT1.getPrereq());
        assertEquals("", CT1.getObjective());
        assertEquals("", CT1.getOutcome());
        assertEquals("", CT1.getContent());

    }

    @Test
    public void testConstructorCourseInputWithValues() {
        Course CT2 = new Course("Title", "Description", 123,
                "CourseCode", "Evaluation", 321,
                "Prerequisites", "Objective", "Outcome", "Content");

        assertEquals("Title", CT2.getTitle());
        assertEquals("Description", CT2.getDescription());
        assertEquals(123, CT2.getProfessor());
        assertEquals("CourseCode", CT2.getCourseCode());
        assertEquals("Evaluation", CT2.getEvaluation());
        assertEquals(321, CT2.getCP());
        assertEquals("Prerequisites", CT2.getPrereq());
        assertEquals("Objective", CT2.getObjective());
        assertEquals("Outcome", CT2.getOutcome());
        assertEquals("Content", CT2.getContent());


    }

    @Test
    public void testSetTitle() {
        Course CT3 = new Course();

        CT3.setTitle("CourseTITLE");
        assertEquals("CourseTITLE", CT3.getTitle());

    }
}
