package Practice_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadSafeMapExample {
    public static Map<String, Integer> threadSafeMap;

    static {
        Map<String, Integer> map = new HashMap<>();
        threadSafeMap = Collections.synchronizedMap(map);
    }

    public static void add(String key, Integer value) {
        synchronized (threadSafeMap) {
            threadSafeMap.put(key, value);
        }
    }

    public static Integer get(String key) {
        synchronized (threadSafeMap) {
            return threadSafeMap.get(key);
        }
    }

    public static void remove(String key) {
        synchronized (threadSafeMap) {
            threadSafeMap.remove(key);
        }
    }
}
