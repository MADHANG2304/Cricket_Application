package thread;

class Sleeper implements Runnable{
    public void run(){
        try {
            System.out.println("Going to sleep");
            Thread.sleep(10000);
            System.out.println("Wake up Naturally");
        } catch (InterruptedException e) {
            System.out.println("Some Thread woke up this thread");
        }
    }
}

public class Interrupt{
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Sleeper());
        t.start();

        Thread.sleep(5000);
        System.out.println("Main class sleep executed");
        t.interrupt();
    }
}
