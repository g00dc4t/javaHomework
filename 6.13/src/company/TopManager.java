package company;

public class TopManager extends Manager{

    public TopManager(Company company) {
        super(company);
    }

    public double getMonthSalary() {
        salary = 80000;
        if (company.getIncome() <= 10000000)
        return salary;
        else
        salary = salary + (salary * 1.5);
        return salary;
    }
}
