package ImmutableClassChallenge;

public class Main {
    public static void main(String[] args) {
        BankCustomer joe = new BankCustomer("Joe", 500.00,
                10000.00);

        System.out.println(joe.toString());

        var list = joe.getAccountList();

        list.clear();
        System.out.println(joe.toString());
    }
}
