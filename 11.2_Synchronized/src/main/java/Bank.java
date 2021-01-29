import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Random;

public class Bank {

    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    private long accountsMoney;

    public Bank () {
        accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(Account fromAccountNum, Account toAccountNum, long amount) {
        Account fromAcc = fromAccountNum;
        Account toAcc = toAccountNum;
        if (fromAcc.getIsBlock() || toAcc.getIsBlock()) {
            return;
        } else {
            if (fromAccountNum.getAccNumber().compareTo(toAccountNum.getAccNumber()) > 0) {
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

    public void doTransfer(Account fromAcc, Account toAcc, long amount) {
        if (amount > 50000) {
            try {
                if (isFraud(fromAcc.getAccNumber(), toAcc.getAccNumber(), amount)) {
                    fromAcc.setIsBlock(true);
                } else {
                    fromAcc.setMoney(fromAcc.getMoney() - amount);
                    toAcc.setMoney(toAcc.getMoney() + amount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

}
