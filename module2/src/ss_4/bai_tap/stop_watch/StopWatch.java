package ss_4.bai_tap.stop_watch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime, endTime;

    public StopWatch() {
        startTime = LocalTime.now();
    }

    public void startTime() {
        startTime = LocalTime.now();
    }

    public void endTime() {
        endTime = LocalTime.now();
    }

    public int getElapsedTime() {
        return  ((endTime.getHour() - startTime.getHour()) * 3600 + (endTime.getMinute() - startTime.getMinute()) * 60 + (endTime.getSecond() - startTime.getSecond()) * 1000);
    }

    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tempt = array[i];
                    array[i] = array[j];
                    array[j] = tempt;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
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
