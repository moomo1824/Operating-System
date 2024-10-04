public class Process {
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int remainingTime;
    private GlobalTimer globalTimer;

    public Process(int id, int arrivalTime, int burstTime, GlobalTimer globalTimer) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.globalTimer = globalTimer;
        this.remainingTime = burstTime;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void runForTime(int time) {
        System.out.println("The process ID: " + id + " is running for " + "Global Time: " + globalTimer.time);
        remainingTime -= time;
        globalTimer.time += time;

        if (remainingTime <= 0) {
            remainingTime = 0;
            System.out.println("-------The process ID: " + id + " has"+" completed its job -------");
        }
    }
}
