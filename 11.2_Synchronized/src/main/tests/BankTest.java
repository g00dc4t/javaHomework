import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class BankTest extends TestCase {

    private Bank bank;

    @Before
    public void setUp() {

        bank = new Bank();

    }

    public void testIsTransfer() {

        Account acc1 = new Account(100000);
        Account acc2 = new Account(100000);

        bank.setAccounts(acc1);
        bank.setAccounts(acc2);

        for (int i = 1; i < 20; i++) {
            new Thread(() -> {
                bank.transfer(acc1, acc2, 10000);
            }).start();
            new Thread(() -> {
                bank.transfer(acc1, acc2, 20000);
            }).start();
            new Thread(() -> {
                bank.transfer(acc2, acc1, 30000);
            }).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long money = bank.getAccountsMoney();
        assertEquals(200000, money);
    }

    @Test
    public void testIsBlock() throws InterruptedException {

        Account acc1 = new Account(1000000);
        Account acc2 = new Account(1000000);

        do {
            new Thread(() -> {
                bank.transfer(acc1, acc2, 55000);
            }).start();
            Thread.sleep(1000);
        } while (!acc1.getIsBlock());

    }
}
