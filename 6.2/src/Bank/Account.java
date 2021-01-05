package Bank;

public class Account {

    private double total;

    public Account(double total) {
        this.total = total;
    }

    protected double getTotal() {
        return total;
    }

    protected void setTotal(double total) {
        this.total = total;
    }

    public void putMoney(double money) {
        setTotal(getTotal() + money);
    }

    public void withdrawMoney(double money) {
        setTotal(getTotal() - money);
    }

    public double showBalance() {
        return getTotal();
    }
}
