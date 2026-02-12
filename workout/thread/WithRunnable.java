package thread;

public class WithRunnable implements Runnable{
    public void run(){
        System.out.println("Thread is running!");
    }

    public static void main(String[] args){
        WithRunnable obj = new WithRunnable();
        new Thread(obj).start();
    }

}
