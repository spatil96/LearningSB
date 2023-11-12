package springbootrestapi.rf2.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.http.Http
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import springbootrestapi.rf2.Pojo.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "studentRE" })
public class StudentControllerWithResponseEntity1
{
    @GetMapping({ "/" })
    public ResponseEntity<Student> getStudent() {
        final Student stu = new Student("Sumeet", 1, "Patil");
        return ResponseEntity.ok().header("custom-header","sumeet").body(stu);
    }
    
    @GetMapping({ "/studentListRE" })
    public ResponseEntity<List<Student>> getStudentList() {
        final List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Shubham", 2, "Jatale"));
        studentList.add(new Student("Ankit", 2, "Mahajan"));
        studentList.add(new Student("Aayushi", 2, "Gupta"));
        return ResponseEntity.ok(studentList);
    }
    
    @GetMapping({ "{id}" })
    public ResponseEntity<Student> getStudentById(@PathVariable final int id) {
        final Student stu = new Student("Shashikant", id, "PAWAR");
        return ResponseEntity.ok(stu);
    }
    
    @GetMapping({ "query" })
    public ResponseEntity<Student> studentRequestParamVariable(@RequestParam final int id) {
        final Student stu = new Student("Rakesh", id, "Roshan");
        return ResponseEntity.ok(stu);
    }
    
    @GetMapping({ "query1" })
    public ResponseEntity<Student> studentRequestParamVariable1(@RequestParam final int id, @RequestParam final String firstName, @RequestParam final String lastName) {
        final Student stu = new Student(firstName, id, lastName);
        return ResponseEntity.ok(stu);
    }
    
    @PostMapping({ "create" })
    public ResponseEntity<Student> studentPost(@RequestBody final Student s) {
        System.out.println(s.getId()+ s.getFirstName()+ s.getLastName());
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
    
    @PutMapping({ "{id}/update" })
    public ResponseEntity<Student> updateStudent(@RequestBody final Student student, @PathVariable("id") final int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }
    
    @DeleteMapping({ "{id}/delete" })
    public ResponseEntity<String> studentDelete(@PathVariable("id") final int stuId) {
        System.out.println(stuId);
        return ResponseEntity.ok("student deleted successfully");
    }
}