import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Account> accountList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            accountList.add(new Account(100000, "acc" + i));
        }

        Bank bank = new Bank();
        for (Account account : accountList) {
            bank.setAccounts(account);
        }

        System.out.println(bank.getTotalAmountMoney() + " total amount money before");
        System.out.println(bank.getAccounts().size() + " accounts before");
        System.out.println(bank.getBlockedAccounts().size() + " block accounts before");

        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new Operation(bank));
            thread.start();
        }

        System.out.println(bank.getTotalAmountMoney() + " total amount money after");
        System.out.println(bank.getAccounts().size() + " accounts after");
        System.out.println(bank.getBlockedAccounts().size() + " block accounts after");
    }
}
