import java.util.concurrent.ThreadLocalRandom;

public class Operation implements Runnable {

    private Bank bank;
    private long randomTransferValue;

    Operation (Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        int randValue1 = ThreadLocalRandom.current().nextInt(30);
        int randValue2 = randValue1 + 1;
        String toAccount = "acc" + randValue1;
        String fromAccount = "acc" + randValue2;
        long randTransferValue = getRandomTransferValue();
        try {
            bank.transfer(toAccount, fromAccount, randTransferValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
