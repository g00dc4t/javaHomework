import java.util.concurrent.ThreadLocalRandom;

public class Operation implements Runnable {

    private Bank bank;
    private long randomTransferValue;

    Operation (Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        
    }

    public static int getRandomTransferValue() {
        int transferValue;
        int rand = (ThreadLocalRandom.current().nextInt(100) < 5) ? 1 : 0;
        if (rand == 1)  {
            transferValue = 51000;
        } else {
            transferValue = 49000;
        }
        return transferValue;
    }
}
