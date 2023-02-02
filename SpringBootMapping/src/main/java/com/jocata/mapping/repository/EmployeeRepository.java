package com.jocata.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.mapping.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
