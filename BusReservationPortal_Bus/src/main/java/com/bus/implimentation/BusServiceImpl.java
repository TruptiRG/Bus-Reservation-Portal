package com.bus.implimentation;

import java.util.List;
import java.util.Optional;

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
		
		Bus addbus = busrepo.save(bus);
		
		if(bus!=null) {
			return bus;
		}else {
			throw new BusException("Bus Details Not Added");
		}	
	}

//	@Override
//	public Bus updateBus(Bus bus) throws BusException {
//		Optional<Bus> opt = busrepo.findById(bus.getBusId());
//		if(opt.isPresent()) {
//			Bus updateBus = busrepo.save(bus);
//			
//			return updateBus;
//		} else {
//			throw new BusException("Invalid Bus Details");
//		}
//	}
//
//	@Override
//	public Bus deleteBus(Integer busId) throws BusException {
//       Optional<Bus> opt = busrepo.findById(busId);
//		
//		if(opt.isPresent()) {
//			Bus bus = opt.get();
//			
//			busrepo.delete(bus);
//			return bus;
//		} else {
//			throw new BusException("Bus Not Found :"+busId);
//		}
//	}
//
//	@Override
//	public Bus viewBus(Integer busId) throws BusException {
//		return busrepo.findById(busId).orElseThrow(()-> new BusException());
//	}

//	@Override
//	public List<Bus> viewBusByType(String busType) throws BusException {
//		List<Bus> list = busrepo.viewBusByType(busType);
//		if(list.size()>0) {
//			return list;
//		}
//		throw new BusException("Bus Not Found With Given Type :"+busType);
//		
//	}
//
//	@Override
//	public List<Bus> viewAllBus() throws BusException {
//         List<Bus> bus = busrepo.findAll();
//		
//		if(bus.size()>0) {
//			return bus;
//		} else {
//			
//			throw new BusException("No Bus Found");
//		}
//	}

}
