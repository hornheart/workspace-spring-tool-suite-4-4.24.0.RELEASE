package com.mybatis3.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tutor implements Serializable
{
	private Integer tutorId;
	private String name;
	private String email;
	private Address address;
	
	private List<Course> courses;

}
