package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private Environment env;
	
	@Value("${dm}")
	private String dm;
	@Value("${jh}")
	private String javahome;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("abc: "+env.getProperty("abc"));
		System.out.println("PATH: "+env.getProperty("PATH"));
		System.out.println("JAVA_HOME: "+env.getProperty("JAVA_HOME"));
		System.out.println("DM: "+dm);
		System.out.println("JH: "+javahome);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
