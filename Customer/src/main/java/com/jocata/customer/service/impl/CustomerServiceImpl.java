package com.jocata.customer.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.customer.dao.CustomerDao;
import com.jocata.customer.entity.CustomerDetails;
import com.jocata.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Serializable save(CustomerDetails customerDetails) {
		return customerDao.save(customerDetails);
	}

	@Override
	public List<CustomerDetails> getAll() {

		return customerDao.getAll();

	}

	@Override
	public CustomerDetails get(int id) {
		
		return customerDao.get(id);
	}

	@Override
	public void deleteById(int id) {
		customerDao.deleteById(id);
		
	}

	

	
}
