package thread;

public class Locks {
    private int c1 = 0;
    private int c2 = 0;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // Here is the problem that both thread are working on 2 different methods but they uses same lock. So after the thread 1 gets exits thread to enters.
    // public synchronized void inc1(){
    //     System.out.println("Thread1 Entered");

    //     try {
    //         Thread.sleep(2000);
    //     } catch (Exception e) {
    //     }

    //     c1++;

    //     System.out.println("Thread1 Exits");
    // }
    // public synchronized void inc2(){
    //     System.out.println("Thread2 Entered");
        
    //     try {
    //         Thread.sleep(2000);
    //     } catch (Exception e) {
    //     }
        
    //     c2++;

    //     System.out.println("Thread2 Exits");
    // }
    
    
    // After initializing individual objects they work parallely and synchronized.
    public void inc1(){
        // System.out.println("Thread1 Entered");
        synchronized (lock1) {
            c1++;
            // System.out.println("Thread1 Exits");
        }
    }
    public void inc2(){
        // System.out.println("Thread2 Entered");
        synchronized (lock2) {
            c2++;
        }
        // System.out.println("Thread2 Exits");
    }

    public void display(){
        System.out.println("c1: " + c1 + " c2:" + c2);
    }

    public static void main(String[] args) throws InterruptedException {
        Locks l = new Locks();

        Thread t1 = new Thread(() -> {
            for(int i = 0;i < 50; i++){
                l.inc1();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0;i < 50; i++){
                l.inc2();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        l.display();
    }
}


