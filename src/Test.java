import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Test {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void doWork1() {
        synchronized (lock1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                synchronized (lock2) {
                    System.out.println("Working object 1");
                }
            }
        }
    }

    private void doWork2() {
        synchronized (lock2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                synchronized (lock1) {
                    System.out.println("Working object 2");
                }
            }
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        ExecutorService service = newFixedThreadPool(2);
        service.execute(() -> test.doWork1());
        service.execute(() -> test.doWork2());


        service.shutdown();


    }
}
