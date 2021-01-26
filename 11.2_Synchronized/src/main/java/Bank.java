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
        if (!(accounts.containsKey(fromAccountNum)) || !(accounts.containsKey(toAccountNum))) {
            throw new NullPointerException("no such account or it has been blocked");
        } else {
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
    }

    public void subtractAndAddMoney (String fromAccountNum, String toAccountNum, long amount) {
        Account fromAcc = accounts.get(fromAccountNum);
        synchronized (fromAcc) {
            fromAcc.setMoney(fromAcc.getMoney() - amount);
        }
        Account toAcc = accounts.get(toAccountNum);
        synchronized (toAcc) {
            toAcc.setMoney(toAcc.getMoney() + amount);
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

    public void blockAccounts (String fromAccountNum, String toAccountNum) {
        blockedAccounts.put(fromAccountNum, accounts.get(fromAccountNum));
        accounts.remove(fromAccountNum);
        blockedAccounts.put(toAccountNum, accounts.get(toAccountNum));
        accounts.remove(toAccountNum);
    }
}
