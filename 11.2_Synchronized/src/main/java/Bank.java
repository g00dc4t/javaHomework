import java.util.HashMap;
import java.util.Random;

public class Bank {

    private HashMap<String, Account> accounts;
    private HashMap<String, Account> blockedAccounts;
    private final Random random = new Random();
    private long totalAmountMoney;
    private long accountsMoney;
    private long blockedAccountsMoney;

    public Bank () {
        accounts = new HashMap<>();
        blockedAccounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount < 50000) {
            subtractAndAddMoney(fromAccountNum, toAccountNum, amount);
        } else {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                blockAccounts(fromAccountNum, toAccountNum);
            } else {
                subtractAndAddMoney(fromAccountNum, toAccountNum, amount);
            }
        }
    }

    public void subtractAndAddMoney (String fromAccountNum, String toAccountNum, long amount) {
        accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
        accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
    }

    public long getBalance(String accountNum) {
        long balance = 0;
        balance = accounts.get(accountNum).getMoney();
        return balance;
    }

    public long getAccountsMoney() {
        for (String s : accounts.keySet()) {
            accountsMoney += getBalance(s);
        }
        return accountsMoney;
    }

    public long getBlockedAccountsMoney() {
        for (String s : blockedAccounts.keySet()) {
            blockedAccountsMoney += getBalance(s);
        }
        return blockedAccountsMoney;
    }

    public long getTotalAmountMoney() {
        totalAmountMoney = getAccountsMoney() + getBlockedAccountsMoney();
        return totalAmountMoney;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public HashMap<String, Account> getBlockedAccounts() {
        return blockedAccounts;
    }

    public void blockAccounts (String fromAccountNum, String toAccountNum) {
        blockedAccounts.put(fromAccountNum, accounts.get(fromAccountNum));
        accounts.remove(fromAccountNum);
        blockedAccounts.put(toAccountNum, accounts.get(toAccountNum));
        accounts.remove(toAccountNum);
    }
}
