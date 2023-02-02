package com.jocata.student.dao;

import java.io.Serializable;
import java.util.List;

import com.jocata.student.entity.Student;


public interface StudentDao {
	
	public Serializable save(Student student);

	public void update(Student student);

	public void delete(Integer id);

	public <T> List<T> loadEntityByHql();

}
