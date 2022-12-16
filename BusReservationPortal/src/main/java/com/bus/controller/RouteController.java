package com.bus.controller;

import com.bus.exception.RoutExeception;
import com.bus.model.Route;
import com.bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
public class RouteController {
    @Autowired
    RouteService rs;

    @PostMapping  ("/route")
    public Route addsRoot(@RequestBody Route rout) throws RoutExeception {
        Route root =rs.addRout(rout);
        if(root==null){
            throw new RoutExeception("data not saved...");
        }else{
            return root;
        }
    }
    @GetMapping("/routebyid/{id}")
    public Route viewsbyid(@PathVariable("id")Integer id) throws RoutExeception{
        Route root=rs.viewById(id);
        if(root==null){
            throw new RoutExeception("data not found....");
        }else{
            return root;
        }
    }
    @DeleteMapping("/routbyid/{id}")
    public Route delete(@PathVariable("id")Integer id)throws RoutExeception{
        Route ro=rs.deleteRoute(id);
        if (ro==null){
            throw new RoutExeception("no any data found");
        }
        else {
            return ro;
        }
    }
    @PostMapping("/routbyid/{id}")
    public Route update(@PathVariable("id")Integer id)throws RoutExeception{
        Route rt=rs.update(id);
        if(rt==null){
            throw new RoutExeception("data not found");
        }
        else {
            return  rt;
        }
    }
     public List<Route> viewAllHandler() throws RoutExeception {


         List<Route> list = rs.viewAll();
        return list;
     }
}
