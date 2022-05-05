class App extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Processing...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}

public class Processor {

    public static void main(String[] args) throws InterruptedException {
        App app1 = new App();
        app1.start();

        Thread.sleep(1000);

        app1.shutDown();
    }

}