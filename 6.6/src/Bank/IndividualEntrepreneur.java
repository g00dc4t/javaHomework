package Bank;

public class IndividualEntrepreneur extends Client {

    public IndividualEntrepreneur(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        if (money < 1000) setAccount(getAccount() + (money - money * 0.01));
        else if (money >= 1000) setAccount(getAccount() + (money - money * 0.005));
    }

    @Override
    public void withdrawMoney(double money) {
        setAccount(getAccount() - money);
    }
}
