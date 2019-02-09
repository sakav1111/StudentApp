package app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
/*If repository class is outside package of the  @SpringBootApplication, 
 * then Spring boot will not be able to detect repository classes by default.
 *  In this case we need to use @EnableJpaRepositories annotation with @SpringBootApplication.
*/
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
		System.out.println("========================== ");
		System.out.println(" STUDENT APP : http://localhost:8080 ");
		System.out.println("================================\n");
		
		System.out.println("LIST : http://localhost:8080/api/list");
		System.out.println("GET : http://localhost:8080/api/get/id");
		System.out.println("ADD : http://localhost:8080/api/add");
		System.out.println("UPDATE : http://localhost:8080/api/update");
		System.out.println("DELETE : http://localhost:8080/api/delete");		
		System.out.println("DEL BY ID : http://localhost:8080/api/delete/id");
		System.out.println("================================");
		
		System.out.println(" \n ===========Mongo urls====================");
		System.out.println("LIST : http://localhost:8080/mongo/list");
		System.out.println("GET : http://localhost:8080/mongo/get/{sno}");
		System.out.println("ADD : http://localhost:8080/mongo/add");
		System.out.println("UPDATE : http://localhost:8080/mongo/update");
		System.out.println("DELETE : http://localhost:8080/mongo/delete");		
		System.out.println(" ================================");
		
		
		
		
	}

}

