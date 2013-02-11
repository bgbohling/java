
class Deposit {

    static int balance = 1000;  // simulate the balance kept remotely

    public static void main(String[] args) {
        Account account = new Account();
        DepositThread first, second;

        first  = new DepositThread(account, 1000, "#1");
        second = new DepositThread(account, 1000, "\t\t\t\t#2");

        // start the transactions
        first.start();
        second.start();

        // wait for both transactions to finish
        try {

            first.join();

            second.join();

        } catch (InterruptedException e) {}

        // print out the final balance
        System.out.println("*** Final balance is " + balance);

    }

}

class Account {

    // void deposit(int amount, String name) {
    synchronized void deposit(int amount, String name) {

        int balance;

        System.out.println(name + " trying to deposit " + amount);
        System.out.println(name + " getting balance...");

        balance = getBalance();

        System.out.println(name + " balance got is " + balance);

        balance += amount;

        System.out.println(name + " setting balance...");

        setBalance(balance);

        System.out.println(name + " new balance set to " + Deposit.balance);

    }
   
    int getBalance() {

        try { 
            // simulate the delay in getting balance remotely
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        return Deposit.balance;

    }

    void setBalance(int balance) {

       try {  
           // simulate the delay in setting new balance remotely
           Thread.sleep(5000);
        } catch (InterruptedException e) {}

        Deposit.balance = balance;

    }

}

class DepositThread extends Thread {

    Account account;
    int     deposit_amount;
    String  message;

    DepositThread(Account account, int amount, String message) {
        this.message  = message;
        this.account  = account;
        this.deposit_amount = amount;
    }

    public void run() {
        account.deposit(deposit_amount, message);
    }

}

