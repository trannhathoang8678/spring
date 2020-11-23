package lesson1.activity15;

public class BankAccount {
    private long amount = 20000000;

    public BankAccount(long amount) {
        this.amount = amount;
    }

    public BankAccount() {
    }

    public synchronized void withThread(String threadName, long withAmount)
    {
        System.out.println(threadName + " need: " + withAmount);
        if(withAmount>amount)
        {
            System.out.println(threadName + " withdraw error");
        }
        else
        {
            System.out.println(threadName + "withdraw success: " + withAmount);
            amount-=withAmount;
        }
        System.out.println(threadName + "see balance: " + amount);
    }
}
class WithdrawThread extends Thread
{
    String threadName;
    BankAccount bankAccount;
    long withAmount;

    public WithdrawThread(String threadName, BankAccount bankAccount, long withAmount) {
        this.threadName = threadName;
        this.bankAccount = bankAccount;
        this.withAmount = withAmount;
    }

    public WithdrawThread() {
    }

    @Override
    public void run() {
        bankAccount.withThread(threadName,withAmount);
    }
}