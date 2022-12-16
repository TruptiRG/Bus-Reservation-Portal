package com.bus.repository;

import com.bus.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.Root;

public interface RouteRepo extends JpaRepository<Route,Integer> {

}
