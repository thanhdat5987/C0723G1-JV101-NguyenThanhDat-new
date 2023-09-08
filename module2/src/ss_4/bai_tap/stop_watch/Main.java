package ss_4.bai_tap.stop_watch;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        StopWatch newStopWatch = new StopWatch();
        newStopWatch.startTime();
        newStopWatch.selectionSort(array);
        newStopWatch.endTime();
        System.out.println("Duration running time is: " + newStopWatch.getElapsedTime());
//        for (int x : array) {
//            System.out.println(x);
//        }
    }
}
