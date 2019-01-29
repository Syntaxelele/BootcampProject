package bootcamp.project;
//----------------------------IMPORTS----------------------------------//

import bootcamp.project.courses.Course;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.users.Professor;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.validation.constraints.NotNull;

//---------------------------------------------------------------------//

public class testCourses {
    @Test
    public void testDefaultInput() {
        Course CT1 = new Course();

        assertEquals("", CT1.getTitle());
        assertEquals("", CT1.getDescription());
        assertNull(CT1.getProfessor());
        assertEquals("", CT1.getCourseCode());
        assertEquals("", CT1.getEvaluation());
        assertEquals(0, CT1.getCP());
        assertEquals("", CT1.getPrereq());
        assertEquals("", CT1.getObjective());
        assertEquals("", CT1.getOutcome());
        assertEquals("", CT1.getContent());

    }

    @InjectMocks
    ProfessorRepo professorRepo;


    @Test
    public void testConstructorCourseInputWithValues() {

        Professor CP1 = new Professor("Janis", "Berzins", "jberzins", "berzins", 1, "j@gmail.com");


        professorRepo.save(CP1);

        Course CT2 = new Course("Title", "Description", CP1,
                "CourseCode", "Evaluation", 321,
                "Prerequisites", "Objective", "Outcome", "Content");


        Iterable<Professor> pFromDB = professorRepo.findByName("jberzins");

        assertEquals("Title", CT2.getTitle());
        assertEquals("Description", CT2.getDescription());
        assertEquals(CP1.getUsername(), CT2.getProfessor().getUsername());
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
