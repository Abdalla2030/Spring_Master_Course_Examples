package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name="Lucy";
    //private final Vehicle vehicle;

    // Best choice
    // I can make bean as a final bean
    // if I have only one constructor -> writing @Autowired -> is optional
    @Autowired
    public Person(Vehicle vehicle){
        System.out.println("Person bean created by Spring");
        this.vehicle = vehicle;
    }

    /*
    The @Autowired annotation marks on a field, constructor, Setter method
    is used to auto-wire the beans that is ‘injecting beans'(Objects) at runtime
    by Spring Dependency Injection mechanism
    * */

//       @Autowired
//    Can not be final
//    @Autowired(required=false) -> if the Vehicle may not founded in IOC Container (optional)
//    person.getVehicle() -> will be null
      private Vehicle vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

//    @Autowired
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

}