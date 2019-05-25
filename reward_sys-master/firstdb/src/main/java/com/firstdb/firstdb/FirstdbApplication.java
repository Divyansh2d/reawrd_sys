package com.firstdb.firstdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={ "com.fristdb.firstdb","entity","jdbc"})

public class FirstdbApplication implements CommandLineRunner {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	//private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	person_jdbc_data dao;
	public static void main(String[] args)
	{
		SpringApplication.run(FirstdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users --> {}",dao.findall());

	}
}
