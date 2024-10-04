import java.util.Comparator;
import java.util.PriorityQueue;

public class PreemptivePriority {

    static PriorityQueue<Process> processQueue =new PriorityQueue<>(10, new Comparator<Process>() {
        public int compare(Process process1,Process process2) {
            return process1.getArrivalTime() - process2.getArrivalTime();
        }
    });

    static PriorityQueue<Process> readyQueue=new PriorityQueue<>(10, new Comparator<Process>() {
        public int compare(Process process1, Process process2) {
            if (process1.getPriority() == process2.getPriority()) {
                return process1.getArrivalTime() - process2.getArrivalTime();
            }
            return process1.getPriority() - process2.getPriority();
        }
    });

    static GlobalTimer globalTimer =new GlobalTimer(0);
    static Process currentProcess =null;

    public void runScheduler() {

        while (!processQueue.isEmpty() || !readyQueue.isEmpty() || currentProcess != null) {
            if (checkIfNewProcessArrived()) {
                while (!processQueue.isEmpty() && processQueue.peek().getArrivalTime() <= globalTimer.time) {
                    readyQueue.add(processQueue.poll());
                }
            }

            if (!readyQueue.isEmpty()) {
                Process nextProcess = readyQueue.peek();
                if (currentProcess == null || nextProcess.getPriority() < currentProcess.getPriority()) {
                    if (currentProcess != null) {
                        readyQueue.add(currentProcess);
                    }
                    currentProcess = readyQueue.poll();
                }
            }

            if (currentProcess != null) {
                currentProcess.runningOnce();
                if (currentProcess.getRemainingTime() == 0) {
                    currentProcess = null;
                }
            } else {
                System.out.println("There is currently no processes in the CPU and Global time is : " + globalTimer.time);
            }

            globalTimer.time++;
        }

        System.out.println("All the processes are completed.");
    }

    public static boolean checkIfNewProcessArrived() {
        return !processQueue.isEmpty() && processQueue.peek().getArrivalTime() <= globalTimer.time;
    }
}
