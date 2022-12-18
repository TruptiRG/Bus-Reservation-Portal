package com.bus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routId;
    private String routeFrom;
    private  String routeTo;
    private Integer distance;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="route")
    private List<Bus> busList;

}
