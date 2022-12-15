package com.bus.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.exception.BusException;
import com.bus.model.Bus;
import com.bus.repository.BusRepo;
import com.bus.service.BusService;

@Service
public class BusServiceImpl implements BusService{
	
	@Autowired
	private BusRepo busrepo;

	@Override
	public Bus addBus(Bus bus) throws BusException {
		return null;
		
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		return null;
	}

	@Override
	public Bus deleteBus(Integer busId) throws BusException {
		return null;
	}

	@Override
	public Bus viewBus(Integer busId) throws BusException {
		return null;
	}

	@Override
	public List<Bus> viewBusByType(String busType) throws BusException {
		return null;
	}

	@Override
	public List<Bus> viewAllBus() throws BusException {
		return null;
	}

}
