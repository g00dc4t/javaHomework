import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    private long totalAmount;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50000) {
            isFraud(fromAccountNum, toAccountNum, amount);
        } else {
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
        }
    }

    public long getBalance(String accountNum) {
        long balance = 0;
        balance = accounts.get(accountNum).getMoney();
        return balance;
    }

    public long getTotalAmount() {
        for (String s : accounts.keySet()) {
            totalAmount += getBalance(s);
        }
        return totalAmount;
    }

}
