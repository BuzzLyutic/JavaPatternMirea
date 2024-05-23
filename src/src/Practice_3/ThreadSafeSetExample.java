package Practice_3;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class ThreadSafeSetExample {
    public static Set<Integer> threadSafeSet = ConcurrentHashMap.newKeySet();
    private static Semaphore semaphore = new Semaphore(1);

    public static void add(Integer value) throws InterruptedException {
        semaphore.acquire();
        try {
            threadSafeSet.add(value);
        } finally {
            semaphore.release();
        }
    }


    public static boolean contains(Integer value) throws InterruptedException {
        semaphore.acquire();
        try {
            return threadSafeSet.contains(value);
        } finally {
            semaphore.release();
        }
    }

    public static void remove(Integer value) throws InterruptedException {
        semaphore.acquire();
        try {
            threadSafeSet.remove(value);
        } finally {
            semaphore.release();
        }
    }
}
