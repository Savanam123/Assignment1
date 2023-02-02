package com.jocata.customer.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jocata.customer.model.CustomerDetails;

@Repository
public interface CustomerDao {
	public Serializable save(CustomerDetails customerDetails);

	public void update(CustomerDetails customerDetails);

	public void delete(Integer id);

	public <T> List<T> loadEntityByHql();
	
	public CustomerDetails getById(int id);

}
