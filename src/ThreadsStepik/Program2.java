package ThreadsStepik;

public class Program2 {
    private static volatile int counter;

    public static void main(String[] args) {
        Waiter firstIncrementor = new Waiter("firstIncrementor");
        Waiter secondIncrementor = new Waiter("secondIncrementor");
    }

    public static int getCounter() {
        return counter;
    }

    public static synchronized void increment() {
        counter++;
        System.out.println(Program2.getCounter());
    }
}

class Incrementor implements Runnable {
    private String name;
    private Thread thread;

    Incrementor(String threadName) {
        name = threadName;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            Program2.increment();
        }
    }
}