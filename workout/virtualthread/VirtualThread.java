package virtualthread;

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {

        Runnable demo = () -> {
            System.out.println("Current running thread: " + Thread.currentThread());
            
            try {
                Thread.sleep(2000);    
            } catch (InterruptedException e) {
                System.out.println("Ended");
            }
        };

        // // But here the virtual thread are created ine by one but because of sleep they share thr platform thread themselves.
        for(int i = 0;i < 20; i++){
            Thread.startVirtualThread(demo);
        }
        Thread.sleep(1000);

        // In this case all the virtual threads are created at the same time executed and won't share any platform thread.
        // Thread vt = Thread.startVirtualThread(demo);
        // Thread vt1 = Thread.startVirtualThread(demo);
        // Thread vt2 = Thread.startVirtualThread(demo);
        // Thread vt3 = Thread.startVirtualThread(demo);

        // vt.join();
        // vt1.join();
        // vt2.join();
        // vt3.join();


        Thread t1 = new Thread(() -> {
            System.out.println("Platform Thread created => " + Thread.currentThread()); // Thread[#52,Thread-0,5,main]
        });
        
        Thread t2 = Thread.startVirtualThread(() -> {
            System.out.println("Vitrual Thread created => " + Thread.currentThread()); // createdVirtualThread[#56]/runnable@ForkJoinPool-1-worker-7
        });

        t1.start();
        t1.join();
        t2.join(); 

        
    }
}
