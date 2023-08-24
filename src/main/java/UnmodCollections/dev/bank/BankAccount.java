package UnmodCollections.dev.bank;

import UnmodCollections.dev.dto.Transaction;

import java.util.Map;

public class BankAccount {
    enum AccountType {
        CHECKING, SAVINGS
    }
    private final AccountType type;
    private double balance;
    Map<Long, Transaction> transactions;

    protected BankAccount(AccountType type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(type, balance);
    }
}
