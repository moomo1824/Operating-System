import java.util.ArrayList;

public class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int startTime = -1;
    int completeTime;
    GlobalTimer globalTimer;

    public static ArrayList<Process> processList = new ArrayList<>();

    public Process(int id, int arrivalTime, int burstTime, GlobalTimer globalTimer) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.globalTimer = globalTimer;
        processList.add(this);
    }

    public void runProcess() {
        System.out.println("The Running process P" + id + " at time= " + globalTimer.time + "seconds");
        remainingTime--;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int time) {
        startTime = time;
    }

    public int getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(int time) {
        completeTime = time;
    }
}
