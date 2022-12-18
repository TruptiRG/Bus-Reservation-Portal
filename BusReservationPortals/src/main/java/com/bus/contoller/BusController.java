package com.bus.contoller;

import com.bus.exception.BusException;
import com.bus.exception.UserException;
import com.bus.model.Bus;
import com.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busservice;

    @PostMapping("/addBus")
    public ResponseEntity<Bus> AddBusesHandler(@RequestBody Bus bus,@RequestParam String key) throws BusException, UserException {
        Bus addnewbus = busservice.addBus(bus,key);
        return new ResponseEntity<Bus>(addnewbus, HttpStatus.CREATED);

    }
    @PutMapping("/updateBus")
    public ResponseEntity<Bus> UpdateBusDetailsHandler(@RequestBody Bus bus,@RequestParam String key) throws BusException, UserException {

        Bus updatedBusDetails=busservice.updateBus(bus,key);

        return new ResponseEntity<Bus>(updatedBusDetails,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deletebusbyid/{busId}")
    public ResponseEntity<Bus> DeleteBusByIdHandler(Integer busId,@RequestParam String key) throws BusException, UserException {
        return new ResponseEntity<Bus>(busservice.deleteBus(busId,key),HttpStatus.FOUND);

    }

    @GetMapping("/getBusId/{busId}")
    public ResponseEntity<Bus> GetBusByidHandler(@PathVariable Integer busId,@RequestParam String key) throws BusException, UserException {
        return new ResponseEntity<Bus>(busservice.viewBus(busId,key),HttpStatus.FOUND);
    }

    @GetMapping("/getallbuslist")
    public ResponseEntity<List<Bus>>GetAllBusDetails(@RequestParam String key) throws BusException, UserException {
        return new ResponseEntity<List<Bus>>(busservice.viewAllBus(key),HttpStatus.FOUND);

    }

}
