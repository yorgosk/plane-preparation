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
public class JavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Plane A = new Plane("Airliner", "Boeing 007", 200);         // create a Plane
        SecurityEmployee securEmp = new SecurityEmployee("George");         // create a Security Employee
        MaintenanceEmployee mainEmp = new MaintenanceEmployee("Giannis");   // create a Maintenance Employee
        CleaningEmployee cleanEmp = new CleaningEmployee("Kostas");         // create a Cleaning Employee
        System.out.println();       // change line
        A.process(securEmp);        // assign Security Employee to work on Plane
        A.process(mainEmp);         // assign Maintenance Employee to work on Plane
        A.process(cleanEmp);        // assign Cleaning Employee to work on Plane
        System.out.println();       // change line
        securEmp.report();          // Security Employee reports his work
        mainEmp.report();           // Maintenance Employee reports his work
        cleanEmp.report();          // Cleaning Employee reports his work
        System.out.println();       // change line
        A.ready_check();            // check if the Plane is ready
    }
    
}