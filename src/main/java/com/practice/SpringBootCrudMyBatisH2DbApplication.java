package com.practice;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.domain.Employee;

@SpringBootApplication
@MapperScan("com.practice.mapper")
@MappedTypes(Employee.class)
public class SpringBootCrudMyBatisH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudMyBatisH2DbApplication.class, args);
	}

}
