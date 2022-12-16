package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.repository.BusRepo;
import com.bus.service.BusService;
@RestController
@RequestMapping("/busservice")
public class BusController {
	
	@Autowired
	private BusService busservice;
	
	@PostMapping("/addbus")
	public ResponseEntity<Bus> AddBusesHandler(@RequestBody Bus bus) throws BusException{
		Bus addnewbus = busservice.addBus(bus);
		return new ResponseEntity<Bus>(addnewbus, HttpStatus.CREATED);
		
	}
//	@PutMapping("/updatedbus")
//	public ResponseEntity<Bus> UpdateBusDetailsHandler(@RequestBody Bus bus) throws BusException{
//		
//		Bus updatedBusDetails=busservice.updateBus(bus); 
//		
//		return new ResponseEntity<Bus>(updatedBusDetails,HttpStatus.ACCEPTED);	
//	}
//	@DeleteMapping("/deletebustbyid/{busId}")
//	public ResponseEntity<Bus> DeleteBusByIdHandler(Integer busId)throws BusException{
//		return new ResponseEntity<Bus>(busservice.deleteBus(busId),HttpStatus.FOUND);
//		
//	}
//	
//	@GetMapping("/getbybusid/{busId}")
//	public ResponseEntity<Bus> GetBusByidHandler(@PathVariable Integer busId) throws BusException{
//		return new ResponseEntity<Bus>(busservice.viewBus(busId),HttpStatus.FOUND);
//	}
	
//	@GetMapping("/getallbusesbytype/{busType}")
//	public ResponseEntity<List<Bus>> GetBusDetailsBybusType(@PathVariable("busType") String busType)throws BusException{
//		List<Bus> list = busservice.viewBusByType(busType);
//		return new ResponseEntity<List<Bus>>(list,HttpStatus.FOUND);
//	}
//
//	@GetMapping("/getallbuslist")
//	public ResponseEntity<List<Bus>>GetAllBusDetails()throws BusException{
//		return new ResponseEntity<List<Bus>>(busservice.viewAllBus(),HttpStatus.FOUND);
//		
//	}
	
	
}
