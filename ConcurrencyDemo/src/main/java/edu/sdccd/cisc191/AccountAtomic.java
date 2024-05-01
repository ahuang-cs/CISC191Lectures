package edu.sdccd.cisc191;

import java.util.concurrent.atomic.AtomicLong;

public class AccountAtomic implements Account {
    private static AtomicLong balance = new AtomicLong(0);

    @Override
    public void credit(long amount) {
        balance.addAndGet(amount);
    }

    @Override
    public void debit(long amount) {
        balance.addAndGet(-1 * amount);
    }

    @Override
    public long getBalance() {
        return balance.get();
    }
}
