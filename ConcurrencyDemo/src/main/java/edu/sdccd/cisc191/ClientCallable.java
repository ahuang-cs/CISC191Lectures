package edu.sdccd.cisc191;

import java.util.concurrent.Callable;

public class ClientCallable implements Callable<Long> {
    private Account account;
    private long amountPerTransaction;
    private int numberOfTransactions;
    private TransactionType transactionType;
    public ClientCallable(Account account, TransactionType transactionType, long amountPerTransaction, int numberOfTransactions) {
        this.account = account;
        this.transactionType = transactionType;
        this.numberOfTransactions = numberOfTransactions;
        this.amountPerTransaction = amountPerTransaction;
    }

    @Override
    public Long call() {
        long total = 0;
        for(int i=0; i<numberOfTransactions; i++) {
            if(transactionType.equals(TransactionType.CREDIT)) {
                account.credit(amountPerTransaction);
                total += amountPerTransaction;
            } else {
                account.debit(amountPerTransaction);
                total -= amountPerTransaction;
            }
        }
        return total;
    }
}
