package company;

public class Manager implements Employee {

    protected Company company;
    public double salary;

    public Manager(Company company) {
        this.company = company;
        salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        salary = 70000 + ((company.getIncome() / 12 * 0.95));
        return salary;
    }
}