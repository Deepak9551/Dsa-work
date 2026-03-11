package code;

public class mythread extends Thread {
    int count  = 0;
    @Override
    public synchronized void run() {
        System.out.println("CHILD THREAD START");
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("CHILD THREAD END");
    }
}
