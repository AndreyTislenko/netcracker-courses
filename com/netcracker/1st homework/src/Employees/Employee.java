package Employees;

import Employees.Exceptions.PercentTooLargeException;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

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
}

