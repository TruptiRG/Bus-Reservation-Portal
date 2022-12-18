package com.bus.implementation;

import com.bus.exception.BusException;
import com.bus.exception.RouteException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.CurrentSession;
import com.bus.model.Route;
import com.bus.repository.RouteRepo;
import com.bus.repository.SessionRepo;
import com.bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepo rRepo;

    @Autowired
    private SessionRepo srepo;
    @Override
    public Route addRout(Route route, String key) throws RouteException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add Route");
        }

        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {

            Route newRoute = rRepo.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());

            if (newRoute != null)
                throw new RouteException("Route from : " + route.getRouteFrom() + " to " + route.getRouteTo() + " already exists" );
            List<Bus> busList = new ArrayList<>();
            route.setBusList(busList);

            return  rRepo.save(route);
        }
        else throw new UserException("Access denied");
    }

    @Override
    public Route update(Route route, String key) throws RouteException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update Route");
        }

        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {


            Optional<Route> opt = rRepo.findById(route.getRoutId());

            if(opt.isPresent()) {

                Route existingRoute = opt.get();

                if (!existingRoute.getBusList().isEmpty())
                    throw new RouteException("Cannot update Route ! Already buses are Scheduled for this route");

                if (route.getDistance() != null) existingRoute.setDistance(route.getDistance());
                if (route.getRouteFrom() != null) existingRoute.setRouteFrom(route.getRouteFrom());
                if (route.getRouteFrom() != null) existingRoute.setRouteTo(route.getRouteTo());

                Route saved =  rRepo.save(existingRoute);

                return saved;

            }
            else {
                throw new RouteException("No route exist to update please save the Route first");
            }


        }
        else throw new UserException("Access denied");
    }

    @Override
    public Route viewById(Integer routeid, String key) throws RouteException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to view Route");
        }

        Optional<Route> opt =rRepo.findById(routeid);

        if(opt.isPresent()) {

            return opt.get();
        }
        else {
            throw new RouteException("No route found on this "+routeid+" id");
        }
    }

    @Override
    public Route deleteRoute(Integer routeId,String key) throws RouteException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to delete Route");
        }

        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {


            Optional<Route> opt =	rRepo.findById(routeId);

            if(opt.isPresent()) {

                Route rot = opt.get();

                if (!rot.getBusList().isEmpty())
                    throw new RouteException("Cannot delete Route ! Already buses are Scheduled for this route");

                rRepo.delete(rot);

                return rot;

            }
            else {
                throw new RouteException("No route found on this "+routeId+" id");
            }

        }

        throw new UserException("Access denied");


    }

    @Override
    public List<Route> viewAll(String key) throws RouteException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to view Route");
        }

        List<Route> routeList = rRepo.findAll();

        if(routeList.size()!=0) {

            return routeList;
        }else {
            throw new RouteException("Route list is empty");
        }

    }

}
