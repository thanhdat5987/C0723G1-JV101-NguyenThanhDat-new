package ss_4.bai_tap.stop_watch;

import java.time.LocalTime;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    public void startTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void endTime() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public void selectionSort(int[] array) {

        int minIndex;
        int temp;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            // Swap the found minimum element with the first
            // element
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
