package app;


import annotation.CarQualifier;
import jakarta.annotation.Resource;
import model.Car;
import model.CarHandler;
import model.Motorcycle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("model")
public class CustomConfiguration {
	@Bean
	@Qualifier
	public Car getMercedes() {
		return new Car("E280", "Mercedes", "Diesel");
	}

	public static void main(String[] args) throws NoSuchFieldException {
		ConfigurableApplicationContext context = SpringApplication.run(CustomConfiguration.class, args);
		CarHandler carHandler = context.getBean(CarHandler.class);
		carHandler.getVehicles().forEach(System.out::println);
	}

	@Bean
	@Qualifier
	public Car getBmw() {
		return new Car("M5", "BMW", "Petrol");
	}

	@Bean
	@Qualifier
	public Motorcycle getSuzuki() {
		return new Motorcycle("Yamaguchi", "Suzuki", true);
	}
}
