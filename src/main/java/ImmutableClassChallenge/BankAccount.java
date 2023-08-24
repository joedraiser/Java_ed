package ImmutableClassChallenge;

public class BankAccount {
    enum AccountType {
        CHECKING, SAVINGS
    }
    private final AccountType type;
    private final double balance;

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
