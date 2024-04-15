package com.example.jpawithunionandpageableandsorted;

import com.example.jpawithunionandpageableandsorted.sample.Test;
import com.example.jpawithunionandpageableandsorted.sample.TestService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

@SpringBootApplication
public class JpaWithUnionAndPageableAndSortedApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(JpaWithUnionAndPageableAndSortedApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(TestService testService)
	{
		return args -> {
			testService.populateData();

			// This test works fine
			Page<Test> all = testService.getAllPageable();
			all.forEach(System.out::println);

			// This test fails like in my app due to having an ordination
			all = testService.getAllPageableAndSorted();
			all.forEach(System.out::println);
		};
	}
}
