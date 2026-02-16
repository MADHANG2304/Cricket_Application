package virtualthread;

public class Pausing {

    static synchronized void demo(){
        System.out.println("Locked By: " + Thread.currentThread());
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println("Locked released by: " + Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        // Runnable task = () -> {
        //     System.out.println("Started: " + Thread.currentThread());
            
        //     try {
        //         Thread.sleep(2000);
        //     } catch (Exception e) {
        //     }
            
        //     System.out.println("Resumed: " + Thread.currentThread());
        // };

        // Thread.startVirtualThread(task);
        // Thread.startVirtualThread(task);
        // Thread.sleep(3000);


        // Because of synchronised virtual thread pinned to the platform thread and worker cannot be freed.
        for(int i = 0;i < 3; i++){
            Thread.startVirtualThread(() -> demo());
        }
        Thread.sleep(6500);
    }
}
