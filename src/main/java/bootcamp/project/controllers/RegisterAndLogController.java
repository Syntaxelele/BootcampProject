package bootcamp.project.controllers;

import bootcamp.project.courses.Course;
import bootcamp.project.courses.Grade;
import bootcamp.project.helper.EmailSender;
import bootcamp.project.helper.StudentsAndGradesList;
import bootcamp.project.helper.Top;
import bootcamp.project.helper.gradesHelper;
import bootcamp.project.repo.CourseRepo;
import bootcamp.project.repo.GradeRepo;
import bootcamp.project.repo.ProfessorRepo;
import bootcamp.project.repo.StudentRepo;
import bootcamp.project.users.Professor;
import bootcamp.project.users.Student;
import bootcamp.project.users.User;

import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.*;

@Controller
public class RegisterAndLogController {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    ProfessorRepo professorRepo;
    @Autowired
    GradeRepo gradeRepo;


    Logger logger = LoggerFactory.getLogger(RegisterAndLogController.class);

    @GetMapping("/showAllUsers")
    //@GetMapping("/showAllStudents")
    public String showAllStudentsToView(Model model) {
        Iterable<Student> userFromDB = studentRepo.findAll();
        model.addAttribute("allUsers", userFromDB);
        return "showAllUsers";
    }

    @GetMapping("/showAllProfessors")
    public String showAllSProfessorsToView(Model model) {
        Iterable<Professor> userFromDB2 = professorRepo.findAll();
        model.addAttribute("allUsers", userFromDB2);
        return "showAllUsers";
    }

    // SHOW USER BY NAME
    /*
     * @GetMapping("/showUserByName") public String showUserByName(
     *
     * @RequestParam(name = "username", defaultValue = "Janis", required = false)
     * String username, Model model) { //Iterable<User> userResult =
     * userRepo.findByName(username); // model.addAttribute("allUsers", userResult);
     * return "showAllUsers"; }
     */
    //--------------------------------------------------------------------//
    //-----------------------STUDENT--------------------------------------//
    @GetMapping("/StudentMenu/{id}")
    public String doorsStudent(Student student, @PathVariable(name = "id") long id) {
        return "StudentMenu";
    }

    @PostMapping("/StudentMenu/{id}")
    public String showStudentMenu(Student student, @PathVariable(name = "id") long id, @RequestParam(name = "studButton") String button) {
        if (button.equals("regToCourse"))
            return "redirect:/registerToCourse/" + id;
        else if (button.equals("ShowMyCours"))
            return "redirect:/showStudentCourses/" + id;
        else if (button.equals("ShowAllStdCourses"))
            return "redirect:/showAllCourses/" + id;
        else
            return "redirect:/ShowGrades/" + id;
    }
    
    
   @GetMapping("/ShowGrades/{id}")
    public String showGradesToStudent(Student student, @PathVariable(name = "id") long id, Model model) {
    	StudentsAndGradesList listOfStudentGrades = new StudentsAndGradesList();
    	Student stud = studentRepo.findById(id).get();
        ArrayList<Grade> myGrades = gradeRepo.findByStudent(stud);


        for (Grade g : myGrades) {
        	if(g.getGrade()!=0)
        	{
            Student st = g.getStudent();
            //System.out.println(st.getName() + " " + st.getLastname() + " " + g.getGrade());

            gradesHelper gh = new gradesHelper(st.getName(), st.getLastname(), g.getGrade(), g.getCourse().getTitle());

            listOfStudentGrades.addNewItem(gh);
        	}
        	
        }
    	
        model.addAttribute("stGrades", listOfStudentGrades);
    	return "ShowGrades";

    }   @GetMapping("/showStudentCourses/{id}")
    public String showAllCoursesToStudent(Student student, @PathVariable(name = "id") long id, Model model) {
        StudentsAndGradesList listOfStudentGrades = new StudentsAndGradesList();
        Student stud = studentRepo.findById(id).get();
        ArrayList<Grade> myGrades = gradeRepo.findByStudent(stud);


        for (Grade g : myGrades) {
                Student st = g.getStudent();
                //System.out.println(st.getName() + " " + st.getLastname() + " " + g.getGrade());

                gradesHelper gh = new gradesHelper(st.getName(), st.getLastname(), g.getGrade(), g.getCourse().getTitle());

                listOfStudentGrades.addNewItem(gh);
            }
        model.addAttribute("stCourses", listOfStudentGrades);
        return "showStudentCourses";
    }
    
   
    //--------------------------------------------------------------------//
    //-----------------------PROFESSOR------------------------------------//
    @GetMapping("/professorMenu/{id}")
    public String doorsProfessor(Professor professor, @PathVariable(name = "id") long id) {
        return "professorMenu";
    }

    @PostMapping("/professorMenu/{id}")
    public String showProfessorMenu(Professor professor, @PathVariable(name = "id") long id, @RequestParam(name = "profButton") String button) {
        if (button.equals("showMyCourse")) {
            return "redirect:/showCourseOptions/" + id;
        } else if (button.equals("exportGrades"))
            return "redirect:/uploadExcelFile/" + id;
        else if (button.equals("uploadCourse"))
            return "redirect:/DocView/" + id;
        else {
            return "redirect:/insertNewCourse/" + id;
        }
    }
//------------------------COURSE OPTIONS-----------------------------------//

    @GetMapping("/showCourseOptions/{id}")
    public String courseOptions(Professor professor, @PathVariable(name = "id") long id) {
        return "showCourseOptions";
    }

    @PostMapping("/showCourseOptions/{id}")
    public String courseOptions(Professor professor, @PathVariable(name = "id") long id, @RequestParam(name = "optionButton") String button) {
        if (button.equals("setGradesButton")) {
            return "redirect:/setGradesView/" + id;
        } else if (button.equals("showGradesButton"))
            return "redirect:/showGradesView/" + id;
        else {
            return "redirect:/showProfessorCourse/" + id;
        }
    }

    @GetMapping("/showGradesView/{id}")
    public String showGrades(Professor professor, @PathVariable(name = "id") long id, Model model) {

        StudentsAndGradesList listOfdata = new StudentsAndGradesList();
        Professor myProfessor = professorRepo.findById(id).get();

        Course myCourse = courseRepo.findByProfessor(myProfessor);

        ArrayList<Grade> gradesOfMyCourse = gradeRepo.findByCourse(myCourse);


        for (Grade g : gradesOfMyCourse) {

            Student stOfMyCourse = g.getStudent();
            System.out.println(stOfMyCourse.getName() + " " + stOfMyCourse.getLastname() + " " + g.getGrade());

            gradesHelper gh = new gradesHelper(stOfMyCourse.getName(), stOfMyCourse.getLastname(),g.getGrade());

            listOfdata.addNewItem(gh);
        }

        model.addAttribute("dataToEvaluate", listOfdata);
        return "showGradesView";

    }

    @GetMapping("/setGradesView/{id}")
    public String setGradesView(Professor professor, @PathVariable(name = "id") long id, Model model) {

        StudentsAndGradesList listOfdata = new StudentsAndGradesList();
        Professor myProfessor2 = professorRepo.findById(id).get();

        Course myCourse2 = courseRepo.findByProfessor(myProfessor2);

        ArrayList<Grade> gradesOfMyCourse = gradeRepo.findByCourse(myCourse2);


        for (Grade g : gradesOfMyCourse) {

            Student stOfMyCourse2 = g.getStudent();
            System.out.println(stOfMyCourse2.getName() + " " + stOfMyCourse2.getLastname() + " " + g.getGrade());

            gradesHelper gh2 = new gradesHelper(stOfMyCourse2.getName(), stOfMyCourse2.getLastname(), g.getGrade());

            listOfdata.addNewItem(gh2);
        }
        model.addAttribute("setStudentGrades", listOfdata);
        return "setGradesView";

    }

    @PostMapping("setGradesView/{id}")
    public String setGradesViewPost(@PathVariable(name = "id") long id, Professor professor,
                                    StudentsAndGradesList listOfData, BindingResult result){
        if (result.hasErrors()){
            return "setGradesView";
        }
        Professor myProfessor2 = professorRepo.findById(id).get();
        Course myCourse2 = courseRepo.findByProfessor(myProfessor2);
        ArrayList<Grade> gradesOfMyCourse = gradeRepo.findByCourse(myCourse2);

        EmailSender emailsnd = new EmailSender();
        for (int i = 0; i < listOfData.studentsAndGradesList.size(); i++) {
            int gtemp = listOfData.studentsAndGradesList.get(i).getGrade();
            gradesOfMyCourse.get(i).setGrade(gtemp);
            gradeRepo.save(gradesOfMyCourse.get(i));
            String stude_email = gradesOfMyCourse.get(i).getStudent().getEmail();
            if(gradesOfMyCourse.get(i).getGrade() < 4){
                emailsnd.sendSimpleMessage(stude_email,"Your Grade in "+ myCourse2.getTitle(),"Your grade is "+gradesOfMyCourse.get(i).getGrade()+" and you stupid");
            }
            else{
                emailsnd.sendSimpleMessage(stude_email,"Your Grade in "+ myCourse2.getTitle(),"Your grade is "+gradesOfMyCourse.get(i).getGrade()+". Congratulations");
            }
        }





        return "redirect:/showGradesView/" + id;
    }

    //   @PostMapping("/showEvaluationView")
    //   public String testEvaluationViewPost(ListOfInfoForView allDataWithGrade) {
    //       // find JAVA course
    //       Course courseJava = courseRepo.findByTitle("JAVA");
//
    //       // get only grades realted to JAVA course
    //       ArrayList<Grade> gradesInJava = gradeRepo.findByCourse(courseJava);
//
    //       // print out grades
    //       for (InfoForView info : allDataWithGrade.listOfInfoForView)
    //           System.out.println(info.getGrade());
//
    //       // set grades in grade repo - data taken from allDataWithGrade
    //       for (int i = 0; i < gradesInJava.size(); i++) {
    //           gradesInJava.get(i).setGradeValue(allDataWithGrade.getListOfInfoForView().get(i).getGrade());
    //           gradeRepo.save(gradesInJava.get(i));
    //       }
//
    //       return "redirect:/testShowAvgOfCourse";
//
    //   }


    //--------------------------------------------------------------------//
    //-----------------------REGISTRATION---------------------------------//
    @GetMapping("/RegView")
    public String Registerer(Student student, Professor professor) {
        return "RegView";
    }

    @PostMapping("/RegView")
    public String Register(@Valid Student student, Professor professor, BindingResult result) {

        Student findDupeUsername = studentRepo.findByUsername(student.getUsername());
        Student findDupeEmail = studentRepo.findByEmail(student.getEmail());
        Professor findDupeUsernameProf = professorRepo.findByUsername(professor.getUsername());
        Professor findDupeEmailProf = professorRepo.findByEmail(professor.getEmail());

        if (result.hasErrors()) {
        	logger.info("User made validation error while registering.");
            return "RegView";
        } else if (findDupeUsername != null && findDupeUsername.getUsername().equalsIgnoreCase(student.getUsername()) || findDupeUsernameProf != null && findDupeUsernameProf.getUsername().equalsIgnoreCase(professor.getUsername())) {
            logger.info("User tried registering with existing username.");
			return "RegView";
        } else if (findDupeEmail != null && findDupeEmail.getEmail().equalsIgnoreCase(student.getEmail()) || findDupeEmailProf != null && findDupeEmailProf.getEmail().equalsIgnoreCase(professor.getEmail())) {
            logger.info("User tried registering with existing email.");
			return "RegView";
        } else if (student.getRole() == 2) {
            studentRepo.save(student);
            User findbyNameAndPassStud = studentRepo.findByUsernameAndPassword(student.getUsername(), student.getPassword());
            logger.info("New student: " + findbyNameAndPassStud.getName() + " " + findbyNameAndPassStud.getLastname() + ".");
            return "redirect:/StudentMenu/" + findbyNameAndPassStud.getId_u();
        } else if (findDupeUsernameProf != null && findDupeUsernameProf.getUsername().equalsIgnoreCase(professor.getUsername()) || findDupeUsername != null && findDupeUsername.getUsername().equalsIgnoreCase(student.getUsername())) {
        	logger.info("User tried registering with existing username.");
			return "RegView";
        } else if (findDupeEmailProf != null && findDupeEmailProf.getEmail().equalsIgnoreCase(professor.getEmail()) || findDupeEmail != null && findDupeEmail.getEmail().equalsIgnoreCase(student.getEmail())) {
        	logger.info("User tried registering with existing email.");
			return "RegView";
        } else if (student.getRole() == 1) {
            professorRepo.save(professor);
            User findbyNameAndPassProf = professorRepo.findByUsernameAndPassword(professor.getUsername(), professor.getPassword());
            logger.info("New professor: " + findbyNameAndPassProf.getName() + " " + findbyNameAndPassProf.getLastname() + ".");
            return "redirect:/professorMenu/" + findbyNameAndPassProf.getId_u();
        } else 
        	System.out.println("ERROR WITH REGISTRATION - LAST ELSE");
        	return "RegView";
    }
    //--------------------------------------------------------------------//
    //-----------------------FORGOT PASSWORD------------------------------//
    @GetMapping("/forgotPass")
    public String Forgot(Student student, Professor professor) {
        return "forgotpass";
    }
    //--------------------------------------------------------------------//
    //-----------------------DOCUMENT IMPORT------------------------------//
    @GetMapping("/DocView/{id}")
    public String DocReader(@PathVariable(required = false, name = "id") long id, Top top) {

        return "DocReader";
    }

    @PostMapping("/DocView/{id}")
    public String DocReaderPost(@PathVariable(required = false, name = "id") long id, Top top) {
        //Optional<Professor> pr = professorRepo.findById(id);
        //Optional<Professor> findbyIDProf = professorRepo.findById(id);
        Course hot = new Course();
        //Professor P = new Professor("Baiba", "Jauka", "baibaa", "parole", 1, "emails@email.lv");
       // professorRepo.save(P);
        Optional<Professor> ProfFromDB = professorRepo.findById(id);
        //professorRepo.save(pr);
		/*Course c = new Course("Math", "desc", P, "11",
			"test", 1, "afsafas", "dsadas", "dsadsa", "dsadsadas");*/
        try {
            FileInputStream fis = new FileInputStream(top.getDocPath());

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            Iterator bodyElementIterator = xdoc.getBodyElementsIterator();
            while (bodyElementIterator.hasNext()) {
                IBodyElement element = (IBodyElement) bodyElementIterator.next();

                if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<XWPFTable> tableList = element.getBody().getTables();
                    XWPFTable table = tableList.get(0);
                    //for (XWPFTable table : tableList) {
                    System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
                    //for (int i = 0; i < table.getRows().size(); i++) {
                    hot.setTitle(table.getRow(0).getCell(1).getText());
                    hot.setCourseCode(table.getRow(2).getCell(1).getText());
                    hot.setEvaluation(table.getRow(3).getCell(1).getText());
                    //hot.setProfessor(P);
                    hot.setProfessor(ProfFromDB.get());
                    hot.setCP(2);
                    hot.setPrereq(table.getRow(5).getCell(1).getText());
                    hot.setObjective(table.getRow(6).getCell(1).getText());
                    hot.setOutcome(table.getRow(7).getCell(1).getText());
                    System.out.println(table.getRow(8).getCell(1).getText().length());
                    hot.setContent(table.getRow(8).getCell(1).getText());
                    //for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
							/*	System.out.print(table.getRow(i).getCell(0).getText()+": ");
							System.out.println(table.getRow(i).getCell(1).getText());*/
                    //}
                //}
                }
           }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        courseRepo.save(hot);
        return "redirect:/showProfessorCourse/" + id;
    }

    @GetMapping("/showCourses")
    public String createNewStudent2(Student student) {
        return "showAllCourses";
    }


}
