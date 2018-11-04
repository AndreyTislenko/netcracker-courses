package Employees.Managers;

import Employees.Employee;

//A class for checking some stuff.
public class Manager extends Employee {
    private int bonus;
    //private int salary;

    public Manager(int id, String firstName, String lastName, int salary) {
        super(id, firstName, lastName, salary);
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }

    public void setAnotherSalary(int salary) {
        this.salary = salary;
    }

    public int getAnotherSalary() {
        return salary;
    }
}
