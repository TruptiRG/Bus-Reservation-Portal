package com.bus.contoller;

import com.bus.exception.BusException;
import com.bus.exception.RouteException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.model.Route;
import com.bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteService rs;

    @PostMapping("/addRoute")
    public ResponseEntity<Route> addsRoot(@RequestBody Route rout,@RequestParam String key) throws RouteException, UserException {
        Route root = rs.addRout(rout,key);
        return new ResponseEntity<Route>(root, HttpStatus.ACCEPTED);
    }
    @GetMapping("/viewRoutebyid/{id}")
    public ResponseEntity<Route> viewsbyid(@PathVariable("id")Integer id,@RequestParam String key) throws RouteException, UserException {
        Route root = rs.viewById(id,key);
        return new ResponseEntity<Route>(root,HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoutbyid/{id}")
    public ResponseEntity<Route> delete(@PathVariable("id")Integer id,@RequestParam String key) throws RouteException, UserException {
        Route ro = rs.deleteRoute(id,key);
        return new ResponseEntity<>(ro,HttpStatus.OK);
    }

    @PutMapping("/updateRoutbyid/{id}")
    public ResponseEntity<Route> update(@RequestBody Route route,@RequestParam String key) throws RouteException, UserException {

        Route updatedRouteDetails = rs.update(route,key);
        return new ResponseEntity<Route>(updatedRouteDetails,HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewAllroute")
    public ResponseEntity<List<Route>> viewAllHandler(@RequestParam String key) throws RouteException, UserException {
        List<Route> list = rs.viewAll(key);
        return new ResponseEntity<List<Route>>(list,HttpStatus.ACCEPTED);
    }

}
