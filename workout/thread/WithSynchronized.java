package thread;

class Bank{
    private int balance = 10000;
    public synchronized void withdraw(String name, int amount){
        if(balance >= amount){
            System.out.println(name + " withdrawing amount " + amount);
            try {
                Thread.sleep(1000);
                balance -= amount;
                System.out.println(name + " withdrawed amount " + amount);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        else{
            System.out.println("Insufficient amount " + amount);
        }
    }

    public int getBalance(){
        return balance;
    }
}

public class WithSynchronized {
    public static void main(String[] args) throws InterruptedException {
        final Bank account = new Bank();

        Thread t1 = new Thread(() -> account.withdraw("Madhan", 5000));

        Thread t2 = new Thread(new Runnable() {
            public void run(){
                account.withdraw("Rahul", 5000);
            }
        });

        t1.start();
        Thread.sleep(2000);
        System.out.println("Account balance is " + account.getBalance());
        
        t2.start();
        Thread.sleep(2000);
        System.out.println("Account balance is " + account.getBalance());
    }
}
