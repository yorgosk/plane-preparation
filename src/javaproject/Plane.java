/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.Random;    // so that we can generate random values

/**
 *
 * @author george
 */
public class Plane {
    private final String description;           // plane's description
    private final String title;                 // plane's title
    private final int MAXPASSENGERS;            // plane's maximum number of passengers
    private final int ec_size = 3;              // plane's Equipment Compartment size
    private final int pc_size;                  // plane's Passenger Compartment size
    private final CargoBay cb;                  // plane's Cargo Bay
    private final EquipmentCompartment[] ec;    // plane's Equipment Compartment array
    private final PassengerCompartment[] pc;    // plane's Passenger Compartment array
    private Employee emp;                       // an employee assigned to work on the plane
    
    Plane(String d, String t, int maxpassengers){
        description = d;
        title = t;
        MAXPASSENGERS = maxpassengers;
        Random rand = new Random();
        pc_size = rand.nextInt(MAXPASSENGERS/50) + 1;   // n is random in [1, MAXPASSENGERS/50]
        System.out.println("Passenger Compartment size: " + pc_size);
        cb = new CargoBay();                            // create Cargo Bay
        ec = new EquipmentCompartment[ec_size];         // create Equipment Compartment array
        for(int i = 0; i < ec_size; i++) ec[i] = new EquipmentCompartment();    // create each Equipment Compartment
        pc = new PassengerCompartment[pc_size];         // create Passenger Compartment array
        for(int i = 0; i < pc_size; i++) pc[i] = new PassengerCompartment();    // create each Passenger Compartment
        emp = null;                                     // there's currently no Employee assigned on this plane
        System.out.println("A Plane has just been created!");   // plane's construction message
    }
    
    String get_description(){
        return description;
    }
    
    String get_title(){
        return title;
    }
    
    int get_MAXPASSENGERS(){
        return MAXPASSENGERS;
    }
    
    int get_size_of_EquipmentCompartment(){
        return ec_size;
    }
    
    int get_size_of_PassengerCompartment(){
        return pc_size;
    }
    
    void ready_check(){
        cb.ready_check();                                       // check if Cargo Bay is ready
        for(int i = 0; i < ec_size; i++) ec[i].ready_check();   // check if each Equipment Compartment is ready
        for(int i = 0; i < pc_size; i++) pc[i].ready_check();   // check if each Passenger Compartment is ready
        System.out.println("Plane ready to take off!");         // plane's readiness message
    }
    
    void process(Employee E){
        emp = E;                                                // assign argument's Employee to this plane
        cb.process(emp);                                        // employee works on Cargo Bay
        for(int i = 0; i < ec_size; i++) ec[i].process(emp);    // employee works on Equipment Compartment
        for(int i = 0; i < pc_size; i++) pc[i].process(emp);    // employee works on Passenger Compartment
    }
}
