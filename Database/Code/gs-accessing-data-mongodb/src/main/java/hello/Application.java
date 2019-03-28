package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Fadi", "SSSS"));
		repository.save(new Customer("Another Fadi", "SSSS"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Fadi'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Fadi"));

		System.out.println("Customers found with findByLastName('SSSS'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("SSSS")) {
			System.out.println(customer);
		}

	}

}
