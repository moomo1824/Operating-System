import java.util.Comparator;
import java.util.PriorityQueue;

public class RoundRobin {

    static PriorityQueue<Process> processQueue = new PriorityQueue<>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            return process1.getArrivalTime() - process2.getArrivalTime();
        }
    });

    static PriorityQueue<Process> readyQueue = new PriorityQueue<>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            return process1.getArrivalTime() - process2.getArrivalTime();
        }
    });

    static GlobalTimer globalTimer = new GlobalTimer(0);
    private int quantumTime;

    public RoundRobin(int quantumTime) {
        this.quantumTime = quantumTime;
    }

    public void runScheduler() {

        while (!processQueue.isEmpty() || !readyQueue.isEmpty()) {
            checkAndAddNewProcesses();

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();

                int executionTime = Math.min(currentProcess.getRemainingTime(), quantumTime);
                currentProcess.runForTime(executionTime);

                if (currentProcess.getRemainingTime() > 0) {
                    readyQueue.add(currentProcess);
                } else {
                    System.out.println("--------- The process ID: " + currentProcess.getId() + " completed ---------");
                }
            } else {
                System.out.println("No process in the CPU. Global time: " + globalTimer.time);
                globalTimer.time++;
            }
        }

        System.out.println("All the processes are complete.");
    }

    private void checkAndAddNewProcesses() {
        while (!processQueue.isEmpty() && processQueue.peek().getArrivalTime() <= globalTimer.time) {
            readyQueue.add(processQueue.poll());
        }
    }
}
