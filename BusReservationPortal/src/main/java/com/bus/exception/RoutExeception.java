package com.bus.exception;

import com.bus.model.Route;

public class RoutExeception  extends Exception{
    public RoutExeception(){
        super();
    }
    public RoutExeception(String masage){
        super(masage);
    }

}
