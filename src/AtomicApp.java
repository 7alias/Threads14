import java.util.concurrent.atomic.AtomicInteger;

public class AtomicApp {

private AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        AtomicApp app = new AtomicApp(); // строка 1
        app.doWork();
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
count.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count); // Count is: 20000
    }
}