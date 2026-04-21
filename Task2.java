package assignment;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
import java.util.concurrent.*;


public class Task2 {
	// FIX: Changed to AtomicInteger to ensure thread-safe increments without explicit locking
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                // FIX: Used incrementAndGet() to handle atomic updates across 10 threads
                processedCount.incrementAndGet(); 
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getProcessedCount() {
        // FIX: Updated to return the atomic value
        return processedCount.get();
    }
}
