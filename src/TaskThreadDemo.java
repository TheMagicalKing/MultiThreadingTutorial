import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.*;

public class TaskThreadDemo {
    private static Lock lock =new ReentrantLock();
    static SumClass sum = new SumClass();

    public static void main(String[] args) throws InterruptedException {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        Runnable thousandRun = new SynchroThread();

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);


        // Start threads
        thread1.start();
        thread3.start();
        thread2.start();
        for (int i = 0; i < 100000; i++) {
            Thread thousandThread = new Thread(thousandRun);
            thousandThread.start();
        }


    }


    static class SumClass {
        int sum = 0;

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }

    static class SynchroThread implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try{
            sum.setSum(sum.getSum()+1);
            System.out.println(sum.getSum());}
            finally {
                lock.unlock();
            }
        }
    }
}