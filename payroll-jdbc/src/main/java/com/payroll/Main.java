package com.payroll;


import com.payroll.Exceptions.EmployeePayrollException;
import com.payroll.dtos.EmployeePayrollDTOS;
import com.payroll.services.DbService;
import com.payroll.services.PayrollServices;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EmployeePayrollException {

        // UC 1-2
        DbService.getInstance().isConnectionValid();
        List<EmployeePayrollDTOS> employeePayroll = PayrollServices.getEmployeePayrolls();

        for (EmployeePayrollDTOS employeePayrollDto : employeePayroll) {
            System.out.println(employeePayrollDto);
        }

        //UC 3-4
        System.out.println(PayrollServices.getEmployeePayroll(2));
        PayrollServices.updateEmployeeSalary("Bob Smith" , 5000.0);

        // UC 5
        List<EmployeePayrollDTOS> employees = PayrollServices.getEmployeesByDateRange(Date.valueOf("2021-01-01"), Date.valueOf("2023-01-01"));
        for (EmployeePayrollDTOS employee : employees) {
            System.out.println(employee);
        }

    }
}