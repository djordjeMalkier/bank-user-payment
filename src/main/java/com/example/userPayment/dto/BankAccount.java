package com.example.userPayment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Currency;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BankAccount {
    private double balance;

    private Integer idAccount;

    private Currency currency;
    private AccountType accountType;
    private User user;

    private Bank bank;

    public BankAccount(AccountType accountType, Currency currency, User user, int idAccount, Bank bank) {
        if(accountType == null || currency == null || user == null) {
            throw new NullPointerException("Null value while creating account");
        }
        this.accountType = accountType;
        this.balance = 0;
        this.currency = currency;
        this.idAccount = idAccount;
        this.user = user;
        this.bank = bank;
    }

    public BankAccount(AccountType accountType, Currency currency, User user, Bank bank, float balance, int idAccount) {
        this(accountType, currency, user,  idAccount, bank);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", idAccount=" + idAccount +
                ", currency=" + currency +
                ", account type=" + accountType +
                ", user=" + user +
                '}';
    }
}
