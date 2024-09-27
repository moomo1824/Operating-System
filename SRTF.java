import java.util.Comparator;
import java.util.PriorityQueue;

public class SRTF {
    static PriorityQueue<Process> processQueue = new PriorityQueue<Process>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            return (int)(process1.getArrivalTime() - process2.getArrivalTime());
        }
    });

    static PriorityQueue<Process> readyQueue = new PriorityQueue<Process>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            return (int)(process1.getRemainingTime() - process2.getRemainingTime());
        }
    });

    static GlobalTimer globalTimer = new GlobalTimer(0);
    static int totalProcess = 5;

    public void srtfFlow() {
        int completedProcess = 0;

        while (completedProcess < totalProcess) {
            if (checkForNewProcess()) {
                while (!processQueue.isEmpty() && processQueue.peek().getArrivalTime() <= globalTimer.time) {
                    readyQueue.add(processQueue.poll());
                }
            }

            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();

                if (currentProcess.getStartTime() == -1) {
                    currentProcess.setStartTime(globalTimer.time);
                }

                currentProcess.runProcess();
                globalTimer.time++;

                if (currentProcess.getRemainingTime() > 0) {
                    readyQueue.add(currentProcess);
                } else {
                    currentProcess.setCompleteTime(globalTimer.time);
                    completedProcess++;
                }
            } else {
                globalTimer.time++;
            }
        }

        showProcessValues();
    }

    public static boolean checkForNewProcess() {
        if (!processQueue.isEmpty()) {
            return processQueue.peek().getArrivalTime() <= globalTimer.time;
        }
        return false;
    }

    public static void showProcessValues() {
        double totalWaitingTime = 0;
        double totalResponseTime=0;

        for (Process process : Process.processList) {
            int turnAroundTime = process.getCompleteTime() - process.getArrivalTime();
            int waitingTime = turnAroundTime - process.getBurstTime();
            int responseTime = process.getStartTime() - process.getArrivalTime();

            System.out.println("Process P" + process.getId() + ":");
            System.out.println("Complete Time: " + process.getCompleteTime());
            System.out.println("Turnaround Time: " + turnAroundTime);
            System.out.println("Waiting Time: " + waitingTime);

            totalWaitingTime += waitingTime;
            totalResponseTime += responseTime;
        }

        double averageWaitingTime = totalWaitingTime / totalProcess;
        double averageResponseTime = totalResponseTime / totalProcess;
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Response Time: " + averageResponseTime);
    }
}
