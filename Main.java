public class Main {
    public static void main(String[] args) {
        PreemptivePriority preemptivePriorityFlow = new PreemptivePriority();

        PreemptivePriority.processQueue.add(new Process(1, 0, 2, 2, PreemptivePriority.globalTimer));
        PreemptivePriority.processQueue.add(new Process(2, 2, 1, 1, PreemptivePriority.globalTimer));
        PreemptivePriority.processQueue.add(new Process(3, 1, 8, 4, PreemptivePriority.globalTimer));
        PreemptivePriority.processQueue.add(new Process(4, 5, 4, 2, PreemptivePriority.globalTimer));
        PreemptivePriority.processQueue.add(new Process(5, 4, 5, 3, PreemptivePriority.globalTimer));

        preemptivePriorityFlow.runScheduler();
    }
}
