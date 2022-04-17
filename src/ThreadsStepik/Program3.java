package ThreadsStepik;

public class Program3 {
    public static void main(String[] args) {
        Waiter firstWaiter = new Waiter("firstWaiter");
        Waiter secondWaiter = new Waiter("secondWaiter");
    }

    public static synchronized void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
}

class Waiter implements Runnable {
    private String name;
    private Thread thread;

    Waiter(String threadName) {
        name = threadName;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Program3.waitOneSecond();
                System.out.println(this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}