package com.kainos.ea.validator;

import com.kainos.ea.exception.*;
import com.kainos.ea.model.EmployeeRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidatorTest {

    EmployeeValidator employeeValidator = new EmployeeValidator();

    @Test
    public void isValidEmployee_shouldReturnTrue_whenValidEmployee() throws SalaryTooLowException, BankNumberLengthException, FirstNameLengthException,
            LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertTrue(employeeValidator.isValidEmployee(employeeRequest));
    }

    @Test
    public void isValidEmployee_shouldThrowSalaryTooLowException_whenSalaryTooLow() {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                10000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertTrue(employeeRequest.getSalary()<20000);
    }

    /*
    Unit Test Exercise 1

    Write a unit test for the isValidEmployee method

    When the bank number is less than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
     */

    @Test
    void isValidEmployee_smallerBankNumber(){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "1234567",
                "AA1A11AA"
        );

        assertThrows(BankNumberLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 2

    Write a unit test for the isValidEmployee method

    When the bank number is more than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
     */


    @Test
    void isValidEmployee_longerBankNumber(){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "123456789",
                "AA1A11AA"
        );

        assertThrows(BankNumberLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }


    /*
    Unit Test Exercise 3

    Write a unit test for the isValidEmployee method

    When the first name than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */

    @Test
    void isValidEmployee_longerFirstName(){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim012345678901234567890123456789012345678901234567890123456789",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertThrows(FirstNameLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 4

    Write a unit test for the isValidEmployee method

    When the last name than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */

    @Test
    void isValidEmployee_longerLastName(){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs012345678901234567890123456789012345678901234567890123456789",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertThrows(LastNameLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));

    }

    /*
    Unit Test Exercise 5

    Write a unit test for the isValidEmployee method

    When the nin is more than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */

    @Test
    void isValidEmployee_longerNin(){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",//012345678901234567890123456789012345678901234567890123456789",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AAA"
        );
        assertThrows(NinLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));

    }

    /*
    Unit Test Exercise 6

    Write a unit test for the isValidEmployee method

    When the nin is less than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */

    @Test
    void isValidEmployee_shorterNin(){

        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",//012345678901234567890123456789012345678901234567890123456789",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11A"
        );
        assertThrows(NinLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

}