package moudel;

import java.util.Date;

public class EmployeeBuilder {
    private  int id ;
    private String name;
    private boolean gender;
    private Date birth_date;
    private float salary;

    public EmployeeBuilder id(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder gender(boolean gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder birth_date(Date date) {
        this.birth_date = date;
        return this;
    }

    public EmployeeBuilder salary(float salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        return new Employee(id,name,gender,birth_date,salary);
    }

}
