package com.hibernate.demo;

import com.hibernate.demo.dao.PersonJdbcDAO;
import com.hibernate.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HibernateJpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(" Get All Users info -> {}",personJdbcDAO.findAll());
		logger.info("Find User Detail for Users info -> {}",personJdbcDAO.findById(10001));
		logger.info(" Delete User Detail  10007 user from Users info -> {}",personJdbcDAO.deleteById(10007));
		logger.info("Adding User Detail  10007 user from Users info -> {}",personJdbcDAO.insert(new Person(10007,"Pawan","BPL",new Date())));
		logger.info("Update User Detail  10007 user from Users info -> {}",personJdbcDAO.update(new Person(10007,"Pawan","Bhopal,MP",new Date())));
		logger.info(" Get All Users info -> {}",personJdbcDAO.findAllUsingPersonRowMapper());
		logger.info("Find User Detail for Users info -> {}",personJdbcDAO.findByIdUsingPersonRowMapper(10001));
	}
}
