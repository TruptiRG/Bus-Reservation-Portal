package com.bus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.exception.BusException;

import com.bus.model.Bus;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer>{
//	List<Bus> viewBusByType(String busType);

}
