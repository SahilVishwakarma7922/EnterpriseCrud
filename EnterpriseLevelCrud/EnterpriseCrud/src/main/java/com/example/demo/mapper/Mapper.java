package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
