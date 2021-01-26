import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Account> accountList = new ArrayList<>();
        for (int i = 1; i <= 3000; i++) {
            accountList.add(new Account(100000, "acc" + i));
        }

        Bank bank = new Bank();
        for (Account account : accountList) {
            bank.setAccounts(account);
        }

        long totalBefore = bank.getAccountsMoney() + bank.getBlockedAccountsMoney();
        System.out.println(totalBefore + " money before");
        System.out.println(bank.getAccounts().size() + " accounts before");
        System.out.println(bank.getBlockedAccounts().size() + " block accounts before\n");

        for (int i = 1; i <= 1000; i++) {
            Thread thread = new Thread(new Operation(bank));
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long totalAfter = bank.getAccountsMoney() + bank.getBlockedAccountsMoney();
        System.out.println("\n" + totalAfter + " money after");
        System.out.println(bank.getAccounts().size() + " accounts after");
        System.out.println(bank.getBlockedAccounts().size() + " block accounts after");

        for (String s : bank.getBlockedAccounts().keySet()) {
            System.out.println(bank.getBlockedAccounts().get(s).getAccNumber());
        }
    }
}
