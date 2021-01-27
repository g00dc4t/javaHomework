import java.util.HashMap;
import java.util.Random;

public class Bank {

    private HashMap<String, Account> accounts;
    private HashMap<String, Account> blockedAccounts;
    private final Random random = new Random();
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
        Account fromAcc = accounts.get(fromAccountNum);
        Account toAcc = accounts.get(toAccountNum);
        if (!(accounts.containsKey(fromAccountNum)) || !(accounts.containsKey(toAccountNum))) {
            throw new NullPointerException("no such account or it has been blocked");
        } else {
            if (fromAccountNum.compareTo(toAccountNum) > 0) {
                synchronized (fromAcc) {
                    synchronized (toAcc) {
                        doTransfer(fromAcc, toAcc, amount);
                    }
                }
            } else {
                synchronized (toAcc) {
                    synchronized (fromAcc) {
                        doTransfer(fromAcc, toAcc, amount);
                    }
                }
            }
        }
    }

    public void doTransfer(Account fromAcc, Account toAcc, long amount) throws InterruptedException {
        if (amount > 50000) {
            if (isFraud(fromAcc.getAccNumber(), toAcc.getAccNumber(), amount)) {
                blockAccounts(fromAcc, toAcc);
            } else {
                fromAcc.setMoney(fromAcc.getMoney() - amount);
                toAcc.setMoney(toAcc.getMoney() + amount);
            }
        }
    }

    public long getAccountsMoney() {
        accountsMoney = 0;
        for (String s : accounts.keySet()) {
            accountsMoney += accounts.get(s).getMoney();
        }
        return accountsMoney;
    }

    public long getBlockedAccountsMoney() {
        blockedAccountsMoney = 0;
        for (String s : blockedAccounts.keySet()) {
            blockedAccountsMoney += blockedAccounts.get(s).getMoney();
        }
        return blockedAccountsMoney;
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

    public void blockAccounts (Account fromAcc, Account toAcc) {
        blockedAccounts.put(fromAcc.getAccNumber(), accounts.get(fromAcc.getAccNumber()));
        accounts.remove(fromAcc.getAccNumber());
        blockedAccounts.put(toAcc.getAccNumber(), accounts.get(toAcc.getAccNumber()));
        accounts.remove(toAcc.getAccNumber());
    }
}
