package counter;

public class CounterMain {

    public static void main(String[] args) {

        SharedCounter obj = new SharedCounter();

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);

        t1.start();
        t2.start();

       }


}
