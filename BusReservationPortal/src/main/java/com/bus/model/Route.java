package com.bus.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EqualsAndHashCode
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	private String routeFrom;
	
	private String routeTo;
	
	private Integer distance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Bus> busList=new HashSet<>();
	
	
	
}
