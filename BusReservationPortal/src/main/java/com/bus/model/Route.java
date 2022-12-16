package com.bus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routid;
	private String routfrom;
	private  String routTo;
	private Integer distnce;
	List<Bus> buses= new ArrayList<>();
public Route(){

}

	public Route(int routid, String routfrom, String routTo, int distnce, List<Bus> buses) {
		this.routid = routid;
		this.routfrom = routfrom;
		this.routTo = routTo;
		this.distnce = distnce;
		this.buses = buses;
	}

	public int getRoutid() {
		return routid;
	}

	public void setRoutid(int routid) {
		this.routid = routid;
	}

	public String getRoutfrom() {
		return routfrom;
	}

	public void setRoutfrom(String routfrom) {
		this.routfrom = routfrom;
	}

	public String getRoutTo() {
		return routTo;
	}

	public void setRoutTo(String routTo) {
		this.routTo = routTo;
	}

	public int getDistnce() {
		return distnce;
	}

	public void setDistnce(int distnce) {
		this.distnce = distnce;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return "Route{" +
				"routid=" + routid +
				", routfrom='" + routfrom + '\'' +
				", routTo='" + routTo + '\'' +
				", distnce=" + distnce +
				", buses=" + buses +
				'}';
	}
}
