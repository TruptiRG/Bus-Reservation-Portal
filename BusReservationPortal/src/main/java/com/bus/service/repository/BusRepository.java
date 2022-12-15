package com.bus.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{

}
