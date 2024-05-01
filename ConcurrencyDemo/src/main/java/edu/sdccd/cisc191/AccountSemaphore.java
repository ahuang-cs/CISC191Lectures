package edu.sdccd.cisc191;

import java.util.concurrent.Semaphore;

public class AccountSemaphore implements Account {
    private static long balance = 0;
    private static Semaphore semaphore = new Semaphore(2);

    @Override
    public void credit(long amount) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance += amount;
        semaphore.release();
    }

    @Override
    public void debit(long amount) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance -= amount;
        semaphore.release();
    }

    @Override
    public long getBalance() {
        return balance;
    }
}
