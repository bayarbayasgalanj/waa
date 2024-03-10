package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    List<Student> findByName(String name);
    Student findByPhone(String phone);

    List<Student>  findAll();

}

