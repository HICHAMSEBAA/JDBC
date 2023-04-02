package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import moudel.Employee;
import utils.Utlis;

public class EmployeeDB_Imp implements EmployeeDB{
    @Override
    public List<Employee> findAll() {

        List<Employee> employees = new LinkedList<>();
        Connection con = Java_DB.getConnection();
        if (con == null){
            return null;
        }
        String query = "SELECT * FROM `employee` WHERE 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Employee employee = new Employee(resultSet.getInt("id"),
                  //      resultSet.getString("name"),
                    //    resultSet.getBoolean("gender"),
                      //  resultSet.getDate("birth_date"),
                        //resultSet.getFloat("salary"));
                Employee employee = Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birth_date(resultSet.getDate("birth_date"))
                        .salary(resultSet.getFloat("salary")).build();

                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return employees;
    }

    @Override
    public Employee findById(int id) {
        Connection con = Java_DB.getConnection();
        if (con == null){
            return null;
        }
        String query = "SELECT * FROM `employee` WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Employee employee = Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birth_date(resultSet.getDate("birth_date"))
                        .salary(resultSet.getFloat("salary")).build();
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void save(Employee employee) {
        Connection con = Java_DB.getConnection();
        if (con == null){
            return;
        }

        if (employee.getId() > 0){ // UPDATE
            String query = "UPDATE `employee` SET`name`= ?,`salary`= ? WHERE `id`= ?";

            try (PreparedStatement pre = con.prepareStatement(query)) {
                pre.setString(1, employee.getName());
                pre.setFloat(2,employee.getSalary());
                pre.setInt(3,employee.getId());

                pre.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        else { // CREATE
             String query = "INSERT INTO `employee`(`name`, `gender`, `birth_date`, `salary`) VALUES (?,?,?,?)";

             try (PreparedStatement pre = con.prepareStatement(query)) {
                 pre.setString(1, employee.getName());
                 pre.setBoolean(2,employee.getGender());
                 pre.setDate(3,Utlis.getSQLDate(employee.getBirth_date()));
                 pre.setFloat(4,employee.getSalary());

                 pre.executeUpdate();

             } catch (SQLException e) {
                 e.printStackTrace();
             }finally {
                 try {
                     con.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }

        }

    }

    @Override
    public void deleteById(int id) {
        Connection con = Java_DB.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE FROM `employee` WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
