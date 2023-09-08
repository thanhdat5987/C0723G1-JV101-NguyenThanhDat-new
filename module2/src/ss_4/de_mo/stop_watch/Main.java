package ss_4.de_mo.stop_watch;

public class Main {
    public static void main(String[] args) {
        int []array = new int[100000];
        for(int i=0; i<100000;i++){
            array[i]= (int) (Math.random()*100000);
        }
        StopWatch myStopWatch = new StopWatch();
        myStopWatch.start();
        myStopWatch.selectionSort(array);
        myStopWatch.stop();
        System.out.println("Duration time: "+ myStopWatch.getElapsedTime());

    }

}
