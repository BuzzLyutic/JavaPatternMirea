package Practice_5;

public class LazySingletoneSync {
    private static LazySingletoneSync instance;

    private LazySingletoneSync(){}

    public static synchronized LazySingletoneSync getInstance() {
        if (instance == null) {
            instance = new LazySingletoneSync();
        }
        return instance;
    }
}
