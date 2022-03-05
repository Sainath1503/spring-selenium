package com.sai.spring.springselenium;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Autowired
	private User user;

	@Value("${Path}")
	private String path;

	@Value("${fruits}")
	private List<String> fruit;

	@Value("${timeout}")
	private int waittimeout;

	@Value("${myusername}")
	private String username;

	@Value("${TEST_URL:https://www.google.com}")
	private String urlPath;

	@Autowired
	private Faker faker;

	@Autowired
	private Television tv;

	@Autowired
	private SampleClass sampleClass;

	@Test
	void contextLoads() {

		System.out.println("Path Variable - "+path);
		System.out.println("Fruits Properties - "+fruit);
		System.out.println("Fruits Properties Size - "+fruit.size());
		System.out.println("Timeout Value - "+waittimeout);
		System.out.println("Username - "+username);
		System.out.println("Test URL - "+urlPath);
		System.out.println("Salary from App Prop - "+sampleClass.getValue());
		user.printDetails();
		tv.playMovie();


		System.out.println("First Name - "+faker.name().firstName());


	}

	//Dependency Injection without Spring Boot
	/*Address address = new Address();
	Salary salary = new Salary();

	User user  = new User(salary,address);
		user.printDetails();*/


}
