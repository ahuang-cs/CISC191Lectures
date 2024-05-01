package edu.sdccd.cisc191;

public class AccountSyncMethods implements Account {
    private static long balance = 0;

    @Override
    public synchronized void credit(long amount) {
        balance += amount;
    }

    @Override
    public synchronized void debit(long amount) {
        balance -= amount;
    }

    @Override
    public synchronized long getBalance() {
        return balance;
    }
}
