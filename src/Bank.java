public class Bank {

    private Integer money = 10000;

    int getMoney() {
        return this.money;
    }

    void take(int money) {
        synchronized (this.money){this.money -= money;}
    }

    void repay(int money) {
        synchronized (this.money){this.money += money;}
    }

    class Client extends Thread{
//        @Override
        public  void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        while(bank.getMoney()!=0) {
            bank.take(1000);
            bank.take(1000);
            bank.repay(1000);
            System.out.println(bank.getMoney());

            Thread.sleep(1000);
        }
    }
}