package com.payroll;


import com.payroll.dtos.EmployeePayrollDTOS;
import com.payroll.services.PayrollServices;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<EmployeePayrollDTOS> employeePayroll = PayrollServices.getEmployeePayrolls();

        for (EmployeePayrollDTOS employeePayrollDto : employeePayroll) {
            System.out.println(employeePayrollDto);
        }
    }
}