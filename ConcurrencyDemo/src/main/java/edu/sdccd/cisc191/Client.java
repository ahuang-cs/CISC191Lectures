package edu.sdccd.cisc191;

public class Client implements Runnable {
    private Account account;
    private long amountPerTransaction;
    private int numberOfTransactions;
    private TransactionType transactionType;
    public Client(Account account, TransactionType transactionType, long amountPerTransaction, int numberOfTransactions) {
        this.account = account;
        this.transactionType = transactionType;
        this.numberOfTransactions = numberOfTransactions;
        this.amountPerTransaction = amountPerTransaction;
    }

    @Override
    public void run() {
        for(int i=0; i<numberOfTransactions; i++) {
            if(transactionType.equals(TransactionType.CREDIT)) {
                account.credit(amountPerTransaction);
            } else {
                account.debit(amountPerTransaction);
            }
        }
    }
}
