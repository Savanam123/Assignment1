package com.jocata.customer.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.customer.dao.CustomerDao;
import com.jocata.customer.model.CustomerDetails;
import com.jocata.customer.util.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateUtils hibernateUtils;

	@Override
	public Serializable save(CustomerDetails customerDetails) {
		return hibernateUtils.save(customerDetails);
	}

	@Override
	public void update(CustomerDetails customerDetails) {
		hibernateUtils.update(customerDetails);

	}

	@Override
	public void delete(Integer id) {
		String hql = "delete from CustomerDetails where id=" + id;
		hibernateUtils.deleteByHql(hql);

	}

	@Override
	public <T> List<T> loadEntityByHql() {

		String hql = "from CustomerDetails";
		return hibernateUtils.loadEntityByHql(hql);
	}

	@Override
	public CustomerDetails getById(int id) {
		return hibernateUtils.getById(id);
	}
}
