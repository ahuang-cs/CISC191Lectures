package edu.sdccd.cisc191;

public interface Account {
    void credit(long amount);
    void debit(long amount);
    long getBalance();
}
