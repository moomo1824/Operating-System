public class Process {
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int remainingTime;
    private GlobalTimer globalTimer;

    public Process(int id, int arrivalTime, int burstTime, int priority, GlobalTimer globalTimer) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.globalTimer = globalTimer;
        this.remainingTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void runningOnce() {
        if (remainingTime > 0) {
            remainingTime--;
            System.out.println("Process ID: " + id + " is currently running"+ " at Global time: " + globalTimer.time);
        }

        if (remainingTime == 0) {
            System.out.println("--------Process ID: " + id + " is"+" completed ------------");
        }
    }
}
