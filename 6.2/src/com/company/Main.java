package com.company;

import Bank.Account;
import Bank.CardAccount;
import Bank.DepositAccount;

public class Main {

    public static void main(String[] args) {
        Account mainAccount = new Account(100);
        System.out.println(mainAccount.showBalance());
        mainAccount.putMoney(20);
        System.out.println(mainAccount.showBalance());
        mainAccount.withdrawMoney(10);
        System.out.println(mainAccount.showBalance() + "\n");

        DepositAccount depositAccount = new DepositAccount(100);
        System.out.println(depositAccount.showBalance());
        depositAccount.withdrawMoney(50);
        depositAccount.setAmountDays(31);
        depositAccount.withdrawMoney(50);
        System.out.println(depositAccount.showBalance() + "\n");

        CardAccount cardAccount = new CardAccount(100);
        System.out.println(cardAccount.showBalance());
        cardAccount.withdrawMoney(10);
        System.out.println(cardAccount.showBalance());
    }
}
