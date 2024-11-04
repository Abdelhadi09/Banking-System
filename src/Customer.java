import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private static List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public static  List<Account> getAccounts() {
        return accounts;
    }

    public static  void addAccount(Account account) {
        accounts.add(account);
    }
}