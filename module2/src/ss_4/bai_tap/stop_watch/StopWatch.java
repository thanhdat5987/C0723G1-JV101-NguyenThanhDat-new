package ss_4.bai_tap.stop_watch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

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
}
