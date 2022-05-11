import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Processor1 implements Runnable {

    private int elem;

    public Processor1(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        AnotherProcessor.set.put("Key" + elem, 12);
    }
}

class SecondProcessor implements Runnable {

    private int elem;

    public SecondProcessor(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        AnotherProcessor.set.remove("Key" + elem);
    }
}

public class AnotherProcessor {

    static Map<String, Integer> set = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Processor1(i)).start();
            new Thread(new SecondProcessor(i)).start();
        }

        Thread.sleep(1000); // хватит для готового результата

        System.out.println(set);
    }

}