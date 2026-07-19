import java.util.LinkedList;
import java.util.Queue;

class SimpleThreadPool {
    private final Queue<Runnable> taskQueue = new LinkedList<>();
    private final List<WorkerThread> threads = new ArrayList<>();
    private boolean isStopped = false;

    public SimpleThreadPool(int numThreads) {
        for (int i = 0; i < numThreads; i++) {
            WorkerThread worker = new WorkerThread();
            threads.add(worker);
            worker.start();
        }
    }

    public synchronized void submit(Runnable task) {
        if (isStopped) throw new IllegalStateException("Pool stopped");
        taskQueue.add(task);
        notifyAll();
    }

    public synchronized void shutdown() {
        isStopped = true;
        notifyAll();
    }

    private class WorkerThread extends Thread {
        public void run() {
            while (true) {
                Runnable task;
                synchronized (SimpleThreadPool.this) {
                    while (taskQueue.isEmpty() && !isStopped) {
                        try { SimpleThreadPool.this.wait(); }
                        catch (InterruptedException e) { return; }
                    }
                    if (taskQueue.isEmpty() && isStopped) return;
                    task = taskQueue.poll();
                }
                if (task != null) task.run();
            }
        }
    }
}
