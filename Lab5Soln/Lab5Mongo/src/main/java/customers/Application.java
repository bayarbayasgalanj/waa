package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer

		studentDb();
	}

	public void studentDb() {
		Address bayasaAddress = new Address("fairfield", "fairfield", "5606");
		Address shujatAddress = new Address("plano", "plano", "75023");
		Student student1 = new Student(101, "Bayasa", "bayasa@gmail.com", "1234567", bayasaAddress);
		Student student2 = new Student(102, "Shujat", "shujat@gmail.com", "7654321", shujatAddress);
		Student student3 = new Student(202, "John", "john@gmail.com", "765433421", shujatAddress);
		Student student4 = new Student(203, "Tom", "tom@gmail.com", "7654344321", shujatAddress);
		Student student5 = new Student(204, "Jack", "jack@gmail.com", "7654444321", shujatAddress);
		studentService.save(student1);
		studentService.save(student2);
		studentService.save(student3);
		studentService.save(student4);
		studentService.save(student5);

		System.out.println("-----------findAll----------------");
		System.out.println(studentService.findAll());
		System.out.println("-----------findByName----------------");
		System.out.println(studentService.findByName("Bayasa"));
		System.out.println("-----------findByPhone----------------");
		System.out.println(studentService.findByPhone("1234567"));
		System.out.println("-----------findByCity----------------");
		System.out.println(studentService.findByCity("plano"));
	}



}
