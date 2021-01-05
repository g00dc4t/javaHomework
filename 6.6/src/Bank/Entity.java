package Bank;

public class Entity extends Client {

    public Entity(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        setAccount(getAccount() + money);
    }

    @Override
    public void withdrawMoney(double money) {
        setAccount(getAccount() -  money * 1.01);
    }
}
