package com.jocata.customer.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jocata.customer.dao.CustomerDao;
import com.jocata.customer.entity.CustomerDetails;
import com.jocata.customer.util.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	HibernateUtils hibernateUtils;

	@Override
	public Serializable save(CustomerDetails customerDetails) {
		return hibernateUtils.save(customerDetails);

	}

	@Override
	public List<CustomerDetails> getAll() {
		return hibernateUtils.getAll();
	}

	@Override
	public CustomerDetails get(int id) {
		return hibernateUtils.get(id);
	}

	
	@Override
	public void deleteById(int id) {
		hibernateUtils.deleteById(id);
		
	}

}
