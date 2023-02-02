package com.jocata.student.service;

import java.io.Serializable;
import java.util.List;

import com.jocata.student.entity.Student;

public interface StudentService {
	
	public Serializable save(Student student);

	public Student update(Student student);

	public void delete(Integer id);

	public <T> List<T> loadEntityByHql();


}
