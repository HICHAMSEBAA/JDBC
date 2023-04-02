package jdbc;

import moudel.Employee;

import java.util.List;
public interface EmployeeDB {
    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
