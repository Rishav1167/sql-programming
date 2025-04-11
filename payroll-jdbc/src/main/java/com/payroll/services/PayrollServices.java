package com.payroll.services;

import com.payroll.Exceptions.EmployeePayrollException;
import com.payroll.dtos.EmployeePayrollDTOS;
import com.payroll.mapping.ToEmployeePayrollDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollServices {

    // returns us list of all employees
    public static List<EmployeePayrollDTOS> getEmployeePayrolls() throws EmployeePayrollException {
        List<EmployeePayrollDTOS> employeePayrolls = new ArrayList<>();

        String query = """
            SELECT *
            FROM employee e
            JOIN department d ON e.dept_id = d.dept_id
            LEFT JOIN contact c ON e.id = c.employee_id
            LEFT JOIN payroll p ON e.id = p.employee_id
        """;

        try (Connection conn = DbService.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                employeePayrolls.add(ToEmployeePayrollDto.map(rs));
            }
        } catch (Exception e) {
            throw new EmployeePayrollException(e.toString());
        }
        return employeePayrolls;
    }


    // Returns the payroll details of the employee with the specified employee ID
    public static EmployeePayrollDTOS getEmployeePayroll(int employee_id) throws EmployeePayrollException {
        EmployeePayrollDTOS employeePayrollDTOS=null;

        String query = """
            SELECT *
            FROM employee e
            JOIN department d ON e.dept_id = d.dept_id
            LEFT JOIN contact c ON e.id = c.employee_id
            LEFT JOIN payroll p ON e.id = p.employee_id
            WHERE e.id = ?
        """;
        try (Connection conn = DbService.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, employee_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employeePayrollDTOS = ToEmployeePayrollDto.map(rs);
                break;
            }
        }
        catch (Exception e){
            throw new EmployeePayrollException(e.toString());
        }
        return employeePayrollDTOS;
    }

    //

    public static void updateEmployeeSalary(String name, double salary) throws EmployeePayrollException {
        String selectQuery = """
        SELECT p.salary 
        FROM payroll p
        JOIN employee e ON p.payroll_id = e.id 
        WHERE e.name = ?
    """;

        String updateQuery = """
        UPDATE payroll 
        SET salary = ? 
        WHERE payroll_id = (SELECT id FROM employee WHERE name = ?)
    """;

        try (Connection conn = DbService.getConnection()) {
            // Step 1: Fetch and print previous salary
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, name);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    double oldSalary = rs.getDouble("salary");
                    System.out.println("Previous Salary of " + name + ": " + oldSalary);
                } else {
                    System.out.println("Employee not found with name: " + name);
                    return;
                }
            }

            // Step 2: Update salary
            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                updateStmt.setDouble(1, salary);
                updateStmt.setString(2, name);
                updateStmt.executeUpdate();
                System.out.println("Salary updated successfully.");
            }

            // Step 3: Fetch and print updated salary
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, name);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    double updatedSalary = rs.getDouble("salary");
                    System.out.println("Updated Salary of " + name + ": " + updatedSalary);
                }
            }
        } catch (Exception e) {
            throw new EmployeePayrollException(e.getMessage());
        }
    }


}
