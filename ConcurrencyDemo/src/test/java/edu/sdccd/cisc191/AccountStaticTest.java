package edu.sdccd.cisc191;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountStaticTest {
    public static long amountPerTransaction = 100;
    public static int numberOfTransactions = 20000000;

    private int numCPUs;
    private Thread[] threads;

    private Account account;

    @BeforeEach
    void setUp() {
        numCPUs = Runtime.getRuntime().availableProcessors();
        System.out.printf("Number of CPUS: %d", numCPUs);
        threads = new Thread[numCPUs];
    }

    @AfterEach
    void tearDown() {
        for(int i=0; i<numCPUs; i++) {
            threads[i] = new Thread(new Client(account, TransactionType.CREDIT, amountPerTransaction, numberOfTransactions));
            threads[i].start();
        }

        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        assertEquals(numCPUs * amountPerTransaction * numberOfTransactions, account.getBalance());
    }

    @Test
    void accountStaticTest() {
        account = new AccountStatic();
    }

    @Test
    void accountAtomicTest() {
        account = new AccountAtomic();
    }

    @Test
    void accountSyncMethodsTest() {
        account = new AccountSyncMethods();
    }

    @Test
    void accountSyncBlockTest() {
        account = new AccountSyncBlock();
    }

    @Test
    void accountSemaphoreTest() {
        account = new AccountSemaphore();
    }
}