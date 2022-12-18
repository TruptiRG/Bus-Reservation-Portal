package com.bus.service;

import com.bus.exception.RouteException;
import com.bus.exception.UserException;
import com.bus.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RouteService {

    public Route addRout(Route route, String key) throws RouteException, UserException;
    public Route update(Route route, String key) throws RouteException, UserException;
    public  Route viewById(Integer routeid, String key) throws RouteException, UserException;
    public Route deleteRoute(Integer routeid, String key)throws RouteException, UserException;
    public List<Route> viewAll(String key) throws RouteException, UserException;

}
