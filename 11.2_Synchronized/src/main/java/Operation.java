import java.util.concurrent.ThreadLocalRandom;

public class Operation implements Runnable {

    private Bank bank;

    Operation (Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        String fromAccount = Integer.toString(ThreadLocalRandom.current().nextInt(1, 2999));
        String toAccount = Integer.toString(ThreadLocalRandom.current().nextInt(1, 2999) + 1);

        bank.getAccounts().get(fromAccount);
        bank.getAccounts().get(toAccount);

        long randTransferValue = getRandomTransferValue();
        bank.transfer(bank.getAccounts().get(fromAccount), bank.getAccounts().get(toAccount), randTransferValue);
    }

    public static long getRandomTransferValue() {
        long transferValue;
        int rand = (ThreadLocalRandom.current().nextInt(100) < 5) ? 1 : 0;
        if (rand == 1)  {
            transferValue = 51000;
        } else {
            transferValue = 49000;
        }
        return transferValue;
    }
}
