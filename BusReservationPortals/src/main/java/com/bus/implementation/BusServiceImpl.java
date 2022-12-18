package com.bus.implementation;

import com.bus.exception.BusException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.CurrentSession;
import com.bus.model.Route;
import com.bus.repository.BusRepo;
import com.bus.repository.RouteRepo;
import com.bus.repository.SessionRepo;
import com.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busrepo;

    @Autowired
    private SessionRepo srepo;

    @Autowired
    RouteRepo rrepo;

    @Override
    public Bus addBus(Bus bus, String key)throws BusException, UserException{

        CurrentSession loggedInUser=srepo.findByUuid(key);

        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to add Bus");
        }

        if (loggedInUser.getType().equalsIgnoreCase("ADMIN")) {

            Route route =  rrepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());

            if(route!=null) {

                if(route.getBusList().contains(bus)) {
                    throw new BusException("Bus already exists");
                }
                route.getBusList().add(bus);
                bus.setRoute(route);
                return busrepo.save(bus);
            }
            else throw new BusException("Cannot find route for adding Bus");

        }
        else throw new UserException("Unauthorized Access! Only Admin can add bus");

    }

    @Override
    public Bus updateBus(Bus bus, String key)throws BusException, UserException{

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to update Bus");
        }
        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {
            Optional<Bus> opt=	busrepo.findById(bus.getBusId());
            if(opt.isPresent()) {
                Bus curr = opt.get();

                if (curr.getAvailableSeats() != curr.getSeats())
                    throw new BusException("Cannot update Bus already scheduled");

                Route route =  rrepo.findByRouteFromAndRouteTo(curr.getRouteFrom(), curr.getRouteTo());

                if (bus.getRouteFrom() != null && bus.getRouteTo() != null) {
                    route = rrepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());


                    if (route == null)
                        throw new BusException("Invalid route details");
                }

                if (bus.getArrivalTime() != null) curr.setArrivalTime(bus.getArrivalTime());
                if (bus.getAvailableSeats() != null) curr.setAvailableSeats(bus.getAvailableSeats());
                if (bus.getBusName() != null) curr.setBusName(bus.getBusName());
                if (bus.getBusType() != null) curr.setBusType(bus.getBusType());
                if (bus.getDepartureTime() != null) curr.setDepartureTime(bus.getDepartureTime());
                if (bus.getRouteFrom() != null) curr.setRouteTo(bus.getRouteFrom());
                if (bus.getRouteTo() != null) curr.setRouteTo(bus.getRouteTo());
                if (bus.getSeats() != null) curr.setSeats(bus.getSeats());



                Bus updated = busrepo.save(curr);
                route.getBusList().add(updated);
                route.getBusList().remove(bus);

                return updated;

            }
            throw new BusException("Bus with id " + bus.getBusId() + "does not exist");

        }
        else throw new UserException("Unauthorized Access! Only Admin can make changes");

    }

    @Override
    public Bus deleteBus(Integer busId, String key)throws BusException, UserException {

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to delete Bus");
        }
        if (loggedInUser.getType().equalsIgnoreCase("Admin")) {
            Optional<Bus> opt=	busrepo.findById(busId);
            if(opt.isPresent()) {
                Bus exbus=opt.get();

                if (exbus.getAvailableSeats()!= exbus.getSeats())
                    throw new BusException("Cannot delete Bus already scheduled");

                busrepo.delete(exbus);
                return exbus;
            }

            throw new BusException("bus doesn't exists with this "+busId+" id");
        }
        else throw new UserException("Unauthorized Access! Only Admin can delete Bus");


    }

    @Override
    public Bus viewBus(Integer busId, String key) throws BusException, UserException{

        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to view bus");
        }
        Optional<Bus> opt=	busrepo.findById(busId);
        if(opt.isPresent()) {
            Bus exbus=opt.get();

            return exbus;
        }
        throw new BusException("bus doesn't exists with this "+busId+" id");
    }


    @Override
    public List<Bus> viewBusByType(String busType, String key) throws BusException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to view buses");
        }
        List<Bus> bList = busrepo.findByBusType(busType);

        if(bList.size()==0) {
            throw new BusException("bus list is empty");
        }

        return bList;
    }

    @Override
    public List<Bus> viewAllBus(String key) throws BusException, UserException {
        CurrentSession loggedInUser=srepo.findByUuid(key);
        if(loggedInUser==null) {
            throw new UserException("Please provide a valid key to view buses");
        }
        List<Bus> buslist=	busrepo.findAll();
        if(buslist.size()==0) {
            throw new BusException("bus list is empty");
        }
        return buslist;

    }
}
