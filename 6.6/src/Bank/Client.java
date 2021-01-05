package Bank;

public abstract class Client {

    private double account;

    Client(double account) {
        setAccount(account);
    }

    protected double getAccount() {
        return account;
    }

    protected void setAccount(double account) {
        this.account = account;
    }

    protected abstract void putMoney(double money);

    protected abstract void withdrawMoney(double money);

    public double showBalance(){
        return getAccount();
    }
}
