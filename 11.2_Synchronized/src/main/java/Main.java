import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Account> accountList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            accountList.add(new Account(100000, "an" + i));
        }

        Bank bank = new Bank();
        for (Account account : accountList) {
            bank.setAccounts(account);
        }

        System.out.println(bank.getTotalAmountMoney());

        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new Operation(bank));
            thread.start();
        }

        System.out.println(bank.getTotalAmountMoney());


    }
}
