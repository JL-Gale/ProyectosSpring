package org.example.openSpringClass3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpenSpringClass3Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OpenSpringClass3Application.class, args);
		CarRepository carRepository = context.getBean(CarRepository.class);
		System.out.println(carRepository.count());

		carRepository.save(new Car(null, 1999, "Supra", "Toyota"));
		System.out.println(carRepository.count());
		System.out.println(carRepository.findAll());
	}
}
