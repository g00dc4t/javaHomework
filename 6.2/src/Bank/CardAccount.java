package Bank;

public class CardAccount extends Account {

    public CardAccount(double total) {
        super(total);
    }

    public void withdrawMoney(double money) {
        setTotal(getTotal() - (money * 1.01));
    }
}
