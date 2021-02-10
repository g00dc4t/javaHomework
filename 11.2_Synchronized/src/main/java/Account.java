import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Account<number> {

    private long money;
    private String accNumber;
    private boolean isBlock;
    private static int number = 1;

    public Account(long money) {
        this.money = money;
        accNumber = Integer.toString(number);
        number++;
        isBlock = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean block) {
        isBlock = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account<?> account = (Account<?>) o;
        return Objects.equals(accNumber, account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber);
    }
}
