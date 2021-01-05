package company;

import java.util.ArrayList;
import java.util.Collections;

public class Company {

    private double income;
    private ArrayList<Employee> staffList;

    public Company(double income) {
        this.income = income;
        staffList = new ArrayList<>();
    }

    public double getIncome() {
        return income;
    }

    public ArrayList<Employee> getStaffList() {
        return staffList;
    }

    public void hire(String e) {
        if (e.equals("Manager")) {
            staffList.add(new Manager(this));
        }
        if (e.equals("TopManager")) {
            staffList.add(new TopManager(this));
        }
        if (e.equals("Operator")) {
            staffList.add(new Operator(this));
        }
    }

    public void hireAll(int Manager, int TopManager, int Operator) {
        for (int i = 1; i <= Manager; i++) {
            staffList.add(new Manager(this));
        }
        for (int i = 1; i <= TopManager; i++) {
            staffList.add(new TopManager(this));
        }
        for (int i = 1; i <= Operator; i++) {
            staffList.add(new Operator(this));
        }
    }

    public void fireFifty() {
        for (int i = 0; i < getStaffList().size(); i++) {
            getStaffList().remove(0);
        }
    }

    public void getTopSalaryStaff(int count) {
        ArrayList<Double> sortSalaryList = new ArrayList<Double>();
        if (count > getStaffList().size()) System.out.println("В списке нет столько сотрудников");
        else {
            for (Employee e : getStaffList()) sortSalaryList.add(e.getMonthSalary());
            Collections.sort(sortSalaryList);
            Collections.reverse(sortSalaryList);
            for (int i = 0; i < count; i++) System.out.println(i + 1 + ". " + sortSalaryList.get(i));
        }
    }

    public void getLowestSalaryStaff(int count) {
        ArrayList<Double> sortSalaryList = new ArrayList<Double>();
        if (count > getStaffList().size()) System.out.println("В списке нет столько сотрудников");
        else {
            for (Employee e : getStaffList()) sortSalaryList.add(e.getMonthSalary());
            Collections.sort(sortSalaryList);
            for (int i = 0; i < count; i++) System.out.println(i + 1 + ". " + sortSalaryList.get(i));
        }
    }
}
