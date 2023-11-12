package springbootrestapi.rf2.Controller;

import springbootrestapi.rf2.Pojo.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
@RestController
public class StudentController
{
    @GetMapping({ "/student" })
    public Student getStudent() {
        final Student stu = new Student("Sumeet", 1, "Patil");
        return stu;
    }
    
    @GetMapping({ "/studentList" })
    public List<Student> getStudentList() {
        final List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Shubham", 2, "Jatale"));
        studentList.add(new Student("Ankit", 2, "Mahajan"));
        studentList.add(new Student("Aayushi", 2, "Gupta"));
        return studentList;
    }
    
    @GetMapping({ "student/{id}" })
    public Student getStudentById(@PathVariable  int id) {
        return new Student("Shashikant", id, "PAWAR");
    }
    
    @GetMapping({ "student/query" })
    public Student studentRequestParamVariable(@RequestParam  int id) {
        return new Student("Rakesh", id, "Roshan");
    }
    
    @GetMapping({ "student/query1" })
    public Student studentRequestParamVariable1(@RequestParam  int id, @RequestParam  String firstName, @RequestParam  String lastName) {
        return new Student(firstName, id, lastName);
    }
    
    @PostMapping({ "student/create" })
    @ResponseStatus(HttpStatus.CREATED)
    public Student studentPost(@RequestBody  Student s) {
        System.out.println(s.getId() +" "+ s.getFirstName()+" "+s.getLastName());
        return s;
    }
    
    @PutMapping({ "student/{id}/update" })
    public Student updateStudent(@RequestBody  Student student, @PathVariable("id") final int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    
    @DeleteMapping({ "student/{id}/delete" })
    public String studentDelete(@PathVariable("id")  int stuId) {
        System.out.println(stuId);
        return "student deleted successfully";
    }
}