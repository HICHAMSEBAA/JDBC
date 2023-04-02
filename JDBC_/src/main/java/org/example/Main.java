package org.example;
import jdbc.EmployeeDB;
import moudel.Employee;
import java.util.Date;
import jdbc.EmployeeDB_Imp;

import java.util.Scanner;
public class Main {

    static EmployeeDB DB = new EmployeeDB_Imp();
    static Scanner scan = new Scanner(System.in);
    static void inseart(){
        System.out.print(" Name   : ");
        String name = scan.next();
        System.out.print(" Salary : ");
        float salary = scan.nextFloat();
        Employee emp = new Employee(0, name, true, new Date(), salary);
        DB.save(emp);
    }

    static void update(int id){
        System.out.print(" Name   : ");
        String name = scan.next();
        System.out.print(" Salary : ");
        float salary = scan.nextFloat();
        Employee emp = new Employee(id, name, true, new Date(), salary);
        DB.save(emp);
    }



    public static void main(String[] args) {

        System.out.print("""
                ---- Welcom To JDBC Project ----
                    Insert --> 1
                    Update --> 2
                    Delate --> 3
                    Display Id  --> 4
                    Display All --> 5
                ________________________________
                    >>> :  """);
        int check = scan.nextInt();

        switch (check){
            case 1 : {
                System.out.println("--- Insert Option ---");
                Main.inseart();
                break;
            }
            case 2 : {
                System.out.println("--- Update Option ---");
                System.out.print(" ID : ");
                int id = scan.nextInt();
                Main.update(id);
                break;
            }
            case 3 : {
                System.out.println("--- Delate Option ---");
                System.out.print(" ID : ");
                int id = scan.nextInt();
                DB.deleteById(id);
                break;
            }
            case 4 : {
                System.out.println("--- Employee ---");
                System.out.print(" ID : ");
                int id = scan.nextInt();
                System.out.println(DB.findById(id));
                break;
            }
            case 5 : {
                System.out.println("--- List Of Employes ---");
                DB.findAll().forEach(System.out::println);
                break;
            }
            default:{
                break;
            }
        }
    }
}
