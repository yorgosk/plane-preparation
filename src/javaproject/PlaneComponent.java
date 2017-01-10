/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.Random;
/**
 *
 * @author george
 */
abstract class PlaneComponent {
    String description;     // plane component's description
    Employee emp;   // an employee assigned to work on the plane component
    
    PlaneComponent(String d){
        description = d;
        emp = null;         // there's currently no Employee assigned on this plane component
        System.out.println("A Plane Component has just been created!"); // plane component's construction message
    }
    
    void ready_check(){
        System.out.println(description + " OK!");   // the described plane component is ready
    }
    
    void process(Employee E){
        emp = E;                                    // assign argument's Employee to this plane component
        emp.workOn(this);                           // employee works on this component
    }
}

class PassengerCompartment extends PlaneComponent {
    private boolean has_inner;          // does this passenger compartment have an inner passenger compartment
    private PassengerCompartment inner; // the above inner passenger compartment (if it exists)
    
    PassengerCompartment(){
        this(new Random().nextBoolean());     // if a random number is even then true
    }
    
    PassengerCompartment(boolean b){
        super("Passenger Compartment"); // construct plane component
        has_inner = b;                  // has_inner = true or false
        if(has_inner){
            System.out.println("This Passenger Compartment contains an inner Passenger Compartment");
            inner = new PassengerCompartment(false);    // if it has inner, create inner too
        }
        System.out.println("A Passenger Compartment has just been created!");   // passenger compartment's construction message
    }
    
    @Override
    void ready_check(){
        System.out.println(description);    // which plane component are we checking
        super.ready_check();                // check this component
        if(has_inner){
            System.out.println("Checking inner Passenger Compartment");
            inner.ready_check();            // if inner Passenger Compartment exists, check it as well
        }
    }
    
    @Override
    void process(Employee E){
        super.process(E);                   // employee works on this passenger compartment
        if(has_inner) emp.workOn(inner);    // if this passenger compartment has an inner passenger compartment, employee works on that on as well
    }
}

abstract class PrivateCompartment extends PlaneComponent {
    PrivateCompartment(String d){
        super(d);                           // construct plane component
        System.out.println("A Private Compartment has just been created!"); // private compartment's construction message
    }
    
    @Override
    void ready_check(){
        System.out.println(description);    // which plane component are we checking
        super.ready_check();                // check this component
    }
}

class EquipmentCompartment extends PrivateCompartment {
    EquipmentCompartment(){
        super("Equipment Compartment");     // construct private compartment
        System.out.println("An Equipment Compartment has just been created!");  // equipment compartment's construction message
    }
}

class CargoBay extends PrivateCompartment {
    EquipmentCompartment eq;    // each cargo bay contains one equipment compartment
    
    CargoBay(){
        super("Cargo Bay");                 // construct private compartment
        eq = new EquipmentCompartment();    // construct equipment compartment
        System.out.println("A Cargo Bay has just beem created!");   // cargo bay's construction message
    }
    
    @Override
    void ready_check(){
        super.ready_check();                // check this component
        System.out.println("Checking Cargo Bay's Equipment Compartment");
        eq.ready_check();                   // check equipment compartment as well
    }
    
    @Override
    void process(Employee E){
        super.process(E);                   // employee works on this cargo bay
        emp.workOn(eq);                     // employee works on this cargo bay's equipment compartment
    }
}
