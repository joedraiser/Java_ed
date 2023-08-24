package ImmutableClassChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int id_count = 1000000;
    private final int id;
    private final String name;
    private final List<BankAccount> accountList = new ArrayList<>();

    public BankCustomer(String name, double savingsBalance, double checkingBalance) {
        this.id = id_count++;
        this.name = name;
        accountList.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsBalance));
        accountList.add(new BankAccount(BankAccount.AccountType.CHECKING,checkingBalance));
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccountList() {
        return new ArrayList<>(accountList);
    }

    @Override
    public String toString() {
        String[] balances = new String[accountList.size()];
        Arrays.setAll(balances, i -> accountList.get(i).toString());
        return "Customer: %s Id:%015d\n  %s".formatted(name, id, String.join("\n  ", balances));
    }
}
