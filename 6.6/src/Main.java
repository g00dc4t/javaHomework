import Bank.Client;
import Bank.Entity;
import Bank.Individual;
import Bank.IndividualEntrepreneur;

public class Main {

    public static void main(String[] args) {
        Individual one = new Individual(100);
        System.out.println(one.showBalance());
        one.putMoney(20);
        System.out.println(one.showBalance());
        one.withdrawMoney(10);
        System.out.println(one.showBalance() + "\n");

        Entity two = new Entity(100);
        System.out.println(two.showBalance());
        two.putMoney(20);
        System.out.println(two.showBalance());
        two.withdrawMoney(10);
        System.out.println(two.showBalance() + "\n");

        IndividualEntrepreneur three = new IndividualEntrepreneur(100);
        System.out.println(three.showBalance());
        three.putMoney(1000);
        System.out.println(three.showBalance());
        three.withdrawMoney(10);
        System.out.println(three.showBalance());
    }
}
