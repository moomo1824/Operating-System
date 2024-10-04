public class Main {
    public static void main(String[] args) {
        RoundRobin roundRobinScheduler = new RoundRobin(8);

        RoundRobin.processQueue.add(new Process(1, 0, 2, RoundRobin.globalTimer));
        RoundRobin.processQueue.add(new Process(2, 2, 1, RoundRobin.globalTimer));
        RoundRobin.processQueue.add(new Process(3, 1, 8, RoundRobin.globalTimer));
        RoundRobin.processQueue.add(new Process(4, 5, 4, RoundRobin.globalTimer));
        RoundRobin.processQueue.add(new Process(5, 4, 5, RoundRobin.globalTimer));

        roundRobinScheduler.runScheduler();
    }
}
