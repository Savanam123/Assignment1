package com.jocata.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.mapping.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
