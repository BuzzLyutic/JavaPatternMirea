package Practice_4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {
    private final ExecutorService executor;

    // Параметр конструктора, содержащий единственный параметр - количество потоков
    public MyExecutorService(int numberOfThreads) {
        executor = Executors.newFixedThreadPool(numberOfThreads);
    }

    @Override
    public void shutdown() {
        executor.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executor.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executor.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executor.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executor.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executor.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return executor.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executor.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return executor.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

    public static void main(String[] args) {

        MyExecutorService myExecutorService = new MyExecutorService(3);

        // Submit a Runnable task
        myExecutorService.execute(() -> {
            System.out.println("Executing Runnable task in thread: " + Thread.currentThread().getName());
        });

        // Submit a Callable task and get the result
        Future<String> future = myExecutorService.submit(() -> {
            return "Result from Callable task";
        });

        try {
            // Print the result of the Callable task
            System.out.println("Callable task result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Invoke all tasks and print their results
        try {
            List<Callable<String>> tasks = Arrays.asList(
                    () -> "Task 1",
                    () -> "Task 2",
                    () -> "Task 3"
            );
            List<Future<String>> futures = myExecutorService.invokeAll(tasks);
            for (Future<String> task : futures) {
                System.out.println("Task result: " + task.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the ExecutorService
        myExecutorService.shutdown();
        try {
            // Wait for the ExecutorService to terminate
            if (!myExecutorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("ExecutorService did not terminate");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
