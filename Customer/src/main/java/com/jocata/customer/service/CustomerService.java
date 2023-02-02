package com.jocata.customer.service;

import java.io.Serializable;
import java.util.List;

import com.jocata.customer.entity.CustomerDetails;

public interface CustomerService {

	public Serializable save(CustomerDetails customerDetails);

	public List<CustomerDetails> getAll();

	CustomerDetails get(int id);
	
	public void deleteById(int id);

}
