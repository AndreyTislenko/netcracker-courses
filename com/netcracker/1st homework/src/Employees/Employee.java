package Employees;

import Employees.Exceptions.PercentTooLargeException;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    protected int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getName(){
        return getFirstName() + " " + getLastName();
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAnnualSalary(){
        return 12*getSalary();
    }

    public int raiseSalary(int percent) throws PercentTooLargeException {
        if (percent > 100){
            throw new PercentTooLargeException("The employee's salary can't be increased that much at once! By " + percent + "% ! OMG!");
        }
        salary+=salary*percent/100;
        return salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object otherObj){
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (otherObj.getClass() != getClass()) return false;

        Employee otherEmployee = (Employee)otherObj;
        return (id == otherEmployee.getId())&&
                Objects.equals(firstName, otherEmployee.getFirstName())&&
                Objects.equals(lastName, otherEmployee.getLastName())&&
                (salary == otherEmployee.getSalary());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + id;
        result = 31*result + firstName.hashCode();
        result = 31*result + lastName.hashCode();
        result = 31*result + salary;
        return  result;
    }
}

