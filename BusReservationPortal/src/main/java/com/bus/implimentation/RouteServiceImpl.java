package com.bus.implimentation;

import com.bus.exception.RoutExeception;
import com.bus.model.Route;
import com.bus.repository.RouteRepo;
import com.bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteRepo rp;
    @Override
    public Route addRout(Route route) throws RoutExeception {
        Route rout = rp.save(route);
        if (rout == null) {
            throw new RoutExeception("data not saved...");
        } else {
            return rout;
        }
    }

    @Override
    public Route update(Integer id) throws RoutExeception {
        Optional<Route> t=rp.findById(id);
        if(t.isPresent()){
            Route rk=t.get();
            rp.save(rk);

            return  rk;
        }
        else{
            throw new RoutExeception("Data not found");
        }
    }


    @Override
    public Route viewById(Integer id) throws RoutExeception {
        Optional<Route> opt=rp.findById(id);
        if(opt.isPresent()){

            Route r=opt.get();
//            rp.delete(r);
            return r;

        }else{
            throw new RoutExeception("Data not found...");
        }
//        return null;
    }

    @Override
    public Route deleteRoute(Integer id) throws RoutExeception {
        Optional<Route> rt= rp.findById(id);
        if(rt.isPresent()){
            Route route=rt.get();
            rp.delete(route);
            return  route;
        }else{
            throw new RoutExeception("data not deleted...");
        }

    }

    @Override
    public List<Route> viewAll() throws RoutExeception {
        List<Route> list=rp.findAll();
        if(list.isEmpty()){
            throw  new RoutExeception("data not found...");
        }else{
            return list;
        }

    }
}
