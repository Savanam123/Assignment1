package com.jocata.customer.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.customer.dao.impl.CustomerDaoImpl;
import com.jocata.customer.model.CustomerDetails;
import com.jocata.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoImpl customerDaoImpl;

	@Override
	public Serializable save(CustomerDetails customerDetails) {
		Integer newPKID = (Integer) customerDaoImpl.save(customerDetails);
		customerDetails.setId(newPKID);
		return customerDetails;
	}

	@Override
	public CustomerDetails update(CustomerDetails customerDetails) {
		customerDaoImpl.update(customerDetails);
		return customerDetails;
	}

	@Override
	public void delete(Integer id) {
		customerDaoImpl.delete(id);
	}

	@Override
	public <T> List<T> loadEntityByHql() {
		return customerDaoImpl.loadEntityByHql();
		
	}

	@Override
	public CustomerDetails getById(int id) {
		return customerDaoImpl.getById(id);
	}

}
