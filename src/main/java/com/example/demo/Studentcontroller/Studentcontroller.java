import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }
    
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getOneStudent(id);
    }
    
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        Optional<Student> student = studentService.getOneStudent(id);
        if (student.isPresent()) {
            newStudent.setId(id);
            studentService.insertStudent(newStudent);
            return "Updated Successfully";
        }
        return "Student not found";
    }
    
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getOneStudent(id);
        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully";
        }
        return "Student not found";
    }
}