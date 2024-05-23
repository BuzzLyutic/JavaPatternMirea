package Practice_3;
public class TestMap {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i =  0; i <  100; i++) {
                ThreadSafeMapExample.add("key" + i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i =  0; i <  100; i++) {
                ThreadSafeMapExample.get("key" + i);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i =  0; i <  100; i++) {
                ThreadSafeMapExample.remove("key" + i);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ThreadSafeMapExample.threadSafeMap);
    }
}
