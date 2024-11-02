import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            System.out.println("WELCOM TO ABDELHADI BANK ");
            System.out.println("choose one of the options :");
            System.out.println("1. Add an account");
            System.out.println("2. View account balance");
            System.out.println("3. Deposite or Withdraw");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAccount(bank, scanner);
                    break;
                case 2:
                    viewBalance(bank, scanner);
                    break;
                case 3:
                    dipositWithdraw(bank, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
            }

        }

    }

    public static void addAccount(Bank bank, Scanner scanner) {
        System.out.println("enter your customer name");
        String name = scanner.next();
        Customer customer = new Customer(name);
        bank.addCustomer(customer);
        System.out.println("enter account number for your savings account");
        int accountNumber = scanner.nextInt();
        System.out.println("enter account holder name");
        String savingsName = scanner.next();
        SavingsAccount savingsAcount = new SavingsAccount(accountNumber, savingsName);
        Customer.addAccount(savingsAcount);
        System.out.println("enter account number for your cheking account");
        int accountNumberCheking = scanner.nextInt();
        System.out.println("enter account holder name");
        String checkingName = scanner.next();
        ChekingAccount checkingAccount = new ChekingAccount(accountNumberCheking, checkingName);
        Customer.addAccount(checkingAccount);
        System.out.println("account added successfully");

    }

    public static void viewBalance(Bank bank, Scanner scanner) {
        System.out.println("enter account number");
        int accountNumber = scanner.nextInt();
        for (Account account : Customer.getAccounts()) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println("Account balance in your savings account: " + account.getBalance());
                System.out.println("Account balance in your cheking account: " + account.getBalance());
            } else {
                System.out.println("account not found");
            }
        }
    }

    public static void dipositWithdraw(Bank bank, Scanner scanner) {
        System.out.println("enter account number");
        int accountNumber = scanner.nextInt();
        for (Account accounts : Customer.getAccounts()) {
            if (accounts.getAccountNumber() == accountNumber) {
               
                    System.out.println("choose one of the options :");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Exit");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("enter amount to deposit");
                            double amount = scanner.nextDouble();
                            Account.deposit(amount);
                            break;
                        case 2:
                            System.out.println("enter amount to withdraw");
                            double amountWithdraw = scanner.nextDouble();
                            Account.withdraw(amountWithdraw);
    
                            break;
                        case 3:
                            System.out.println("Exiting the program");
                            scanner.close();
                           return;
                         
                        default:
                            System.out.println("invalid choice");
                            return;
                            
                    }
                
               
            } else {
                System.out.println("account not found");
            }
        }
        
    }
}