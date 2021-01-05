import company.Company;

public class Main {

    public static void main(String[] args) {
        Company one = new Company(11000000);
        System.out.println(one.getIncome());

        one.hireAll(4, 1, 1);
        
        System.out.println("_");
        one.getTopSalaryStaff(6);
        System.out.println("_");
        one.getLowestSalaryStaff(6);
        System.out.println("_");
        System.out.println(one.getStaffList().size());

        one.hire("Manager");
        System.out.println(one.getStaffList().size());
        one.fireFifty();
        System.out.println(one.getStaffList().size());
        }
}
