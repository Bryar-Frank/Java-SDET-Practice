package com.skillstorm.hello_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.skillstorm.hello_spring_boot.beans.Vehicle;

/*
 * @SpringBootApplication is a combo of three annotations:
 * 		-------------------------------------------------------------------------------------
 * 		@Configuration			 - specifies class will be a configuration class
 * 									+ class that has beans that Spring needs to manage
 * 		-------------------------------------------------------------------------------------
 * 		@ComponentScan			 - searches package for any class annotated with @Component
 * 									+ makes beans for thos components
 * 		-------------------------------------------------------------------------------------
 * 		@EnableAutoConfiguration - tells SpringBoot to autoconfigure the app context
 * 									+ like a server OR web app 
 * 		-------------------------------------------------------------------------------------
 */

@SpringBootApplication
public class HelloSpringBootApplication implements CommandLineRunner {
	@Autowired				//ask Spring to give a bean instead of going through the application
	@Qualifier("camaro")	//tells Spring which bean to give us
	private Vehicle car3;

	public static void main(String[] args) {
		/*
		 * APPLICATION CONTEXT
		 * 		starts up your IOC (iversion of control) container
		 * 		where all beans live
		 */
		ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
		
		Vehicle car = (Vehicle)context.getBean("tesla");
		System.out.println("I'm driving my new Microwave! WOOO!");
		car.drive();

		Vehicle car2 = (Vehicle)context.getBean("tesla");
		//same memory address because they are set to singleton
		System.out.println("Car 1: " + car);
		System.out.println("Car 2: " + car2);
	}

	/*
	* COMMAND LINE RUNNER
	* 		method that runs AFTER the app context is loaded
	* 
	* 		usually used to perform settup for application
	* 			ie. loading data
	* 
	* 		functional interface (can be a lambda)
	*/
	@Override
	public void run(String... args) throws Exception {
		System.out.println(car3);
		System.out.println("I'm driving my new Camaro");
		car3.drive();
	}

}
