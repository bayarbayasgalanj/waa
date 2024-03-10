package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findByName(String name) {
        return  studentRepository.findByName(name);
    }
    public Student findByPhone(String phone) {
        return  studentRepository.findByPhone(phone);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findByCity(String city) {
        List<Student> students = findAll();
        List<Student> studentList = new ArrayList<>();
        for (Student s : students) {
            if (s.getAddress().getCity().equals(city)) {
                studentList.add(s);
            }
        }
        return studentList;
    }

    public List<Student>  findAll() {
        return  studentRepository.findAll();
    }

}
