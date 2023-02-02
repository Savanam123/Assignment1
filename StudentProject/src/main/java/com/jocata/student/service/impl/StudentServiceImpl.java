package com.jocata.student.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jocata.student.dao.StudentDao;
import com.jocata.student.dao.impl.StudentDaoImpl;
import com.jocata.student.entity.Student;
import com.jocata.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;

	@Override
	public Serializable save(Student student) {
		Integer newInt = (Integer) studentDaoImpl.save(student);
		student.setStuId(newInt);
		return student;
	}

	@Override
	public Student update(Student student) {
		studentDaoImpl.update(student);
		return student;
	}

	@Override
	public void delete(Integer id) {
		studentDaoImpl.delete(id);
	}

	@Override
	public <T> List<T> loadEntityByHql() {
		// TODO Auto-generated method stub
		return null;
	}

}
