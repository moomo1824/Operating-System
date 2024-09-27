public class Main {
    public static void main(String[] args) {
        SRTF srtfProcessFlow = new SRTF();
        SRTF.processQueue.add(new Process(1, 0, 2, SRTF.globalTimer));
        SRTF.processQueue.add(new Process(2, 2, 1, SRTF.globalTimer));
        SRTF.processQueue.add(new Process(3, 1, 8, SRTF.globalTimer));
        SRTF.processQueue.add(new Process(4, 5, 4, SRTF.globalTimer));
        SRTF.processQueue.add(new Process(5, 4, 5, SRTF.globalTimer));
        srtfProcessFlow.srtfFlow();
    }
}
