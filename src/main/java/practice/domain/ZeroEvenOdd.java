package practice.domain;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

// 1116. Print Zero Even Odd
public class ZeroEvenOdd {
    private int n;
    Semaphore zero, even, odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        odd = new Semaphore(0);
        even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int times = this.n;
        boolean printOdd = true;
        for (int i = 0; i < times; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (printOdd)
                odd.release();
            else
                even.release();
            printOdd = !printOdd;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int times = this.n / 2;
        int next = 2;
        for (int i = 0; i < times; i++) {
            even.acquire();
            printNumber.accept(next);
            next += 2;
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int times = this.n / 2;
        int next = 1;
        for (int i = 0; i < times; i++) {
            odd.acquire();
            printNumber.accept(next);
            next += 2;
            zero.release();
        }
    }
}
