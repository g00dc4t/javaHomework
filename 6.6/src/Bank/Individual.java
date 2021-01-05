package Bank;

public class Individual extends Client {

    public Individual(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        setAccount(getAccount() + money);
    }

    @Override
    public void withdrawMoney(double money) {
        setAccount(getAccount() -  money);
    }
}
