package edu.sdccd.cisc191;

public class AccountSyncBlock implements Account {
    private static long balance = 0;

    @Override
    public void credit(long amount) {
        synchronized (AccountSyncBlock.class) {
            balance += amount;
        }
    }

    @Override
    public void debit(long amount) {
        synchronized (AccountSyncBlock.class) {
            balance -= amount;
        }
    }

    @Override
    public long getBalance() {
        synchronized (AccountSyncBlock.class) {
            return balance;
        }
    }
}
