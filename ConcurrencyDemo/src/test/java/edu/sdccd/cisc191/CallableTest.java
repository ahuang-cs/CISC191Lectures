package edu.sdccd.cisc191;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallableTest {
    public static long amountPerTransaction = 100;
    public static int numberOfTransactions = 20000000;

    private int numCPUs;
    ExecutorService executorService;

    private Account account;

    @BeforeEach
    void setUp() {
        numCPUs = Runtime.getRuntime().availableProcessors();
        System.out.printf("Number of CPUS: %d", numCPUs);
        executorService = Executors.newFixedThreadPool(numCPUs);
    }

    @AfterEach
    void tearDown() {

        long totalCredited = 0;
        List<Callable<Long>> clients = new ArrayList<>();
        for(int i=0; i<numCPUs; i++) {
            clients.add(new ClientCallable(account, TransactionType.CREDIT, amountPerTransaction, numberOfTransactions));
        }

        try {
            for(Future<Long> clientAmount: executorService.invokeAll(clients)) {
                totalCredited += clientAmount.get();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        assertEquals(numCPUs * amountPerTransaction * numberOfTransactions, account.getBalance());
        assertEquals(numCPUs * amountPerTransaction * numberOfTransactions, totalCredited);
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