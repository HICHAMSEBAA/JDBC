package moudel;

import java.util.Date;

public class Employee {
    private  int id ;
    private String name;
    private boolean gender;
    private Date birth_date;
    private float salary;

    public Employee() {
    }

    public Employee(int Id, String Name, boolean Gender, Date Birth_Date, float Salary) {
        this.id = Id;
        this.name = Name;
        this.gender = Gender;
        this.birth_date = Birth_Date;
        this.salary = Salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee : " + id +
                "| name = " + name + '\'' +
                "| gender = " + gender + '\'' +
                "| birth_date = " + birth_date +
                "| salary = " + salary ;
    }
}
