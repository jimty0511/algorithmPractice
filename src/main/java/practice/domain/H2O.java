package practice.domain;

import java.util.concurrent.Semaphore;

// 1117. Building H2O
public class H2O {

    Semaphore output, h, o;

    public H2O() {
        output = new Semaphore(1);
        h = new Semaphore(0);
        o = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        output.acquire();
        h.release(2);
        releaseOxygen.run();
        o.acquire(2);
        output.release();
    }
}
