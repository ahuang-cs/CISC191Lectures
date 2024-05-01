package edu.sdccd.cisc191;

public class AccountStatic implements Account {
    private static long balance = 0;

    @Override
    public void credit(long amount) {
        balance += amount;
    }

    @Override
    public void debit(long amount) {
        balance -= amount;
    }

    @Override
    public long getBalance() {
        return balance;
    }
}
