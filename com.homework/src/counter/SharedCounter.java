package counter;

public class SharedCounter implements Runnable {

    private int counter;

    @Override
    public void run() {
        increment();
         }

    void increment(){
        for(int i = 0; i< 50; i++){
            counter++;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
