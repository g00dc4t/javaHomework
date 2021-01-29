import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Account> accountList = new ArrayList<>();
        for (int i = 1; i <= 3000; i++) {
            accountList.add(new Account(100000));
        }

        Bank bank = new Bank();
        for (Account account : accountList) {
            bank.setAccounts(account);
        }

        long totalBefore = bank.getAccountsMoney();
        System.out.println(totalBefore + " money before");
        System.out.println(bank.getAccounts().size() + " accounts before");

        for (int i = 1; i <= 1000; i++) {
            Thread thread = new Thread(new Operation(bank));
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long totalAfter = bank.getAccountsMoney();
        System.out.println("\n" + totalAfter + " money after");

        int countBlockedAcc = 0;
        for (String number : bank.getAccounts().keySet()) {
            if(bank.getAccounts().get(number).getIsBlock()) {
                countBlockedAcc++;
            }
        }
        System.out.println(countBlockedAcc + " accounts after");
    }
}
