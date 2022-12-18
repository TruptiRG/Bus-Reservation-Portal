package com.bus.service;

import com.bus.exception.BusException;
import com.bus.exception.UserException;
import com.bus.model.Bus;

import java.util.List;

public interface BusService {

    public Bus addBus(Bus bus, String key) throws BusException, UserException;
    public Bus updateBus(Bus bus, String key) throws BusException, UserException;
    public Bus deleteBus(Integer busId, String key) throws BusException, UserException;
    public Bus viewBus(Integer busId, String key) throws BusException, UserException;
    public List<Bus> viewBusByType(String busType, String key) throws BusException, UserException;
    public List<Bus> viewAllBus(String key)throws BusException, UserException;
}
