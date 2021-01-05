package Bank;

public class DepositAccount extends Account {

    private int amountDays = 0;

    public DepositAccount(double total) {
        super(total);
    }

    public void putMoney(double money) {
        amountDays = 0;
        setTotal(money);
    }

    public void withdrawMoney(double money) {
        if (amountDays < 30) System.out.println("Деньги не снять прошло меньше 30 дней");
        else setTotal(getTotal() - money);
    }

    public void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }
}
