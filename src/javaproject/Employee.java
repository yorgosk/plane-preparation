/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author george
 */
abstract class Employee {
    private final String name;      // employee's name 
    PlaneComponent workOn;          // a plane component that this employee is assigned to work on
    
    Employee(String n){
        name = n;
        System.out.println("An Employee named " + name + " has just been created!");    // employee's construction message
    }
    
    void workOn(PlaneComponent w){
        workOn = w;                     // assign a plane component to this employee to work on
    }
    
    void report(){
        System.out.println("OK.");      // this employee is reporting OK
    }
}

class SecurityEmployee extends Employee {
    SecurityEmployee(String n){
        super(n);                       // construct employee
        System.out.println("A Security Employee has just been created!");   // security employee's construction message
    }
    
    @Override
    void workOn(PlaneComponent w){
        super.workOn(w);                // assign to this employee the argument's plane component to work on
        System.out.println("This Security Employee secures " + workOn.description); // what is this employee working on
    }
    
    @Override
    void report(){
        System.out.println("This Security Employee reports on: " + workOn.description); // what is this employee reporting
        super.report();                 // report OK
    } 
}

class MaintenanceEmployee extends Employee {
    MaintenanceEmployee(String n){
        super(n);                       // construct employee
        System.out.println("A Maintenance Employee has just been created!");    // maintenance employee's construction message
    }
    
    @Override
    void workOn(PlaneComponent w){
        if("Cargo Bay".equals(w.description) || "Equipment Compartment".equals(w.description)){ // if this employee can work on the argument's plane component
            super.workOn(w);            // assign to this employee the argument's plane component to work on
            System.out.println("This Maintenance Employee checks " + workOn.description);   // what is this employee working on
        }
        else System.out.println("A Maintenance Employee can't work on " + w.description);   // else, tell us what's wrong
    }
    
    @Override
    void report(){
        System.out.println("This Maintenance Employee reports on: " + workOn.description);    // what is this employee reporting
        super.report();                 // report OK
    } 
}

class CleaningEmployee extends Employee {
    CleaningEmployee(String n){
        super(n);                       // construct employee
        System.out.println("A Cleaning Employee has just been created!");   // cleaning employee's construction message
    }
    
    @Override
    void workOn(PlaneComponent w){
        if("Cargo Bay".equals(w.description) || "Passenger Compartment".equals(w.description)){ // if this employee can work on the argument's plane component
            super.workOn(w);            // assign to this employee the argument's plane component to work on
            System.out.println("This Cleaning Employee cleans " + workOn.description);  // what is this employee working on
        }
        else System.out.println("A Cleaning Employee can't work on " + w.description);  // else, tell us what's wrong
    }
    
    @Override
    void report(){
        System.out.println("This Cleaning Employee reports on: " + workOn.description);   // what is this employee reporting
        super.report();                 // report OK
    }
}