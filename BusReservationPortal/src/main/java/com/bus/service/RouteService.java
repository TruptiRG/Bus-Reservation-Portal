package com.bus.service;


import com.bus.exception.RoutExeception;
import com.bus.model.Route;

import javax.persistence.criteria.Root;
import java.util.List;

public interface RouteService {
    public Route addRout(Route route) throws RoutExeception;
    public Route update(Integer id)throws RoutExeception;
    public  Route viewById(Integer id) throws RoutExeception;
    public Route deleteRoute(Integer id)throws RoutExeception;
    public List<Route> viewAll() throws RoutExeception;
}
