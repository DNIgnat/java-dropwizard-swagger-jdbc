package com.kainos.ea.validator;

import com.kainos.ea.exception.*;
import com.kainos.ea.model.EmployeeRequest;

public class EmployeeValidator {
    public boolean isValidEmployee(EmployeeRequest employeeRequest) throws SalaryTooLowException, BankNumberLengthException, FirstNameLengthException,
            LastNameLengthException, NinLengthException {
        if (employeeRequest.getSalary() < 20000) {
            throw new SalaryTooLowException();
        }

        if (employeeRequest.getBankNo().length() != 8) {
            throw new BankNumberLengthException();
        }

        if(employeeRequest.getFname().length()>50){
            throw new FirstNameLengthException();
        }
        if(employeeRequest.getLname().length()>50){
            throw new LastNameLengthException();
        }
        if(employeeRequest.getNin().length() != 8){
            throw new NinLengthException();
        }

        return true;
    }
}
