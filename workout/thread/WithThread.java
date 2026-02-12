package thread;

public class WithThread extends Thread{

    private String name;

    public WithThread(String name){
        this.name = name;
    }
    
    public void run(){

        for(int i = 1;i <= 4; i++)
        {
            System.out.println(name + " is working the task " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        // System.out.println("Thread is running!");
        System.out.println(name + " completed all task");
    }
    public static void main(String[] args) throws InterruptedException {
        // WithThread obj = new WithThread();
        // obj.start();

        // String importantInfo[] = {
        //     "Mares eat oats",
        //     "Does eat oats",
        //     "Little lambs eat ivy",
        //     "A kid will eat ivy too"
        // };

        // for(int i = 0; i < importantInfo.length; i++){
        //     Thread.sleep(3000);
        //     System.out.println(importantInfo[i]);
        // }


        WithThread w1 = new WithThread("Madhan");
        WithThread w2 = new WithThread("Rahul");

        w1.start();
        w1.join(); // Without join() both thread will work simultaneously leads to data inconsistency
        w2.start();
        w2.join();

        System.out.println("Running");
    }
}
