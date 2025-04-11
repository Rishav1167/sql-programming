package com.payroll;


import com.payroll.Exceptions.EmployeePayrollException;
import com.payroll.dtos.EmployeePayrollDTOS;
import com.payroll.services.PayrollServices;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EmployeePayrollException {

        // UC 1-2
        List<EmployeePayrollDTOS> employeePayroll = PayrollServices.getEmployeePayrolls();

        for (EmployeePayrollDTOS employeePayrollDto : employeePayroll) {
            System.out.println(employeePayrollDto);
        }

        //UC 3-4
        System.out.println(PayrollServices.getEmployeePayroll(2));
        PayrollServices.updateEmployeeSalary("Bob Smith" , 5000.0);

    }
}