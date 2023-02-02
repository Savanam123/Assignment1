package com.jocata.student.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.student.dao.StudentDao;
import com.jocata.student.entity.Student;
import com.jocata.student.util.HibernateUtils;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;

	@Override
	public Serializable save(Student student) {
		return hibernateUtils.save(student);
	}

	@Override
	public void update(Student student) {
		hibernateUtils.update(student);
	}

	@Override
	public void delete(Integer id) {
		String hql="delete from Student where id="+id;
		hibernateUtils.deleteByHql(hql);

	}

	@Override
	public <T> List<T> loadEntityByHql() {
		// TODO Auto-generated method stub
		return null;
	}

}
