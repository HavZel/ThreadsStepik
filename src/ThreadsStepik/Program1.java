package ThreadsStepik;

public class Program1 {
    public static void main(String[] args) {
        Enabler enabler = new Enabler();
        Disabler disabler = new Disabler();
    }
}

class Enabler implements Runnable {
    private Thread thread;

    public Enabler() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            enable();
        }
    }

    void enable() { System.out.println("Program enabled"); }
}

class Disabler implements Runnable {
    private Thread thread;

    public Disabler() {
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            disable();
        }
    }

    void disable() {
        System.out.println("Program disabled");
    }
}
