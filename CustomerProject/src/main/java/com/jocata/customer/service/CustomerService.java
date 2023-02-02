package com.jocata.customer.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jocata.customer.model.CustomerDetails;

@Service
public interface CustomerService {

	public Serializable save(CustomerDetails customerDetails);

	public CustomerDetails update(CustomerDetails customerDetails);

	public void delete(Integer id);

	public <T> List<T> loadEntityByHql();
	
	public CustomerDetails getById(int id);

}
