package com.jocata.customer.dao;

import java.io.Serializable;
import java.util.List;

import com.jocata.customer.entity.CustomerDetails;

public interface CustomerDao {

	public Serializable save(CustomerDetails customerDetails);

	public List<CustomerDetails> getAll();

	public CustomerDetails get(int id);
	
	public void deleteById(int id);

}
