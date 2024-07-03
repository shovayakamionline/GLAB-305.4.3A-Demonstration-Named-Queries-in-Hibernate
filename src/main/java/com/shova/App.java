package com.shova;

import com.shova.controller.EmployeeController;

public class App {
    public static void main( String[] args ){
        System.out.println("Hello World! ");
        EmployeeController employeeController = new EmployeeController();
//        employeeController.createEmployeeTable();
//        employeeController.findEmployeeByName();
//        employeeController.findEmployeeById();
          employeeController.showOfficeCodes_AsDepartment();
    }
}
