package javamultithreading;
import java.util.LinkedList;
import java.util.Queue;

public class JavaMultithreading {

    //Queue
    static Queue<Integer> q = new LinkedList<>();

    public static class myClass {

        //Queue max capacity
        int capacity = 10;

        public void produce() throws InterruptedException {
            
            //Counter for pushing into the queue
            int counter = 0;
            while (true) {
                synchronized (this) {

                    //Producer should wait when queue gets full
                    while (q.size() == capacity) {
                        wait();
                    }

                    //Producer producing...
                    System.out.println(Thread.currentThread().getName() + " produced-"
                            + counter);
                    q.add(counter++);
                    
                    //Notifying other threads to carry on
                    notify();
                    
                    //For output visibilty
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    
                    //Consumer should wait when queue is empty
                    while (q.size() == 0) {
                        wait();
                    }
                    //Consumer consuming..
                    int value = q.remove();
                    System.out.println(Thread.currentThread().getName() + " consumed-"
                            + value);
                    
                    //Notifying other threads to carry on..
                    notify();
                  //For output visibility
                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        
        //Initial queue values
        q.add(8);
        q.add(3);
        q.add(1);
        q.add(7);
        q.add(0);
        //This object contains produce and consume methods
         myClass obj = new myClass();
        // Producer 1 
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer 1
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Consummer 2
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.setName("Producer 1");
        t2.setName("Consumer 1");
        t3.setName("Consumer 2");

        // Start all threads 
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

}
