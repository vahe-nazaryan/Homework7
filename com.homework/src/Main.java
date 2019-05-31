import java.util.ArrayList;
        import java.util.List;
        import java.util.*;


public class Main {

    private final static int COUNT = 100000000;
    private final static int THREAD_COUNT = 3;
    private final static int BUTCH_COUNT = COUNT / THREAD_COUNT;


    public static void main(String[] args) throws InterruptedException {
        int [] numbers = new int[COUNT];

        for(int i =0; i<COUNT; i++){
            numbers[i] = i;
        }

        List<Class2> objects = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        if(COUNT % 3 == 0){
            objects.add(new Class2(0, BUTCH_COUNT, numbers));
            objects.add(new Class2(BUTCH_COUNT, BUTCH_COUNT * 2, numbers));
            objects.add(new Class2(BUTCH_COUNT * 2, 3 * BUTCH_COUNT, numbers));
        } else if(COUNT % 3 ==1) {
            objects.add(new Class2(0, BUTCH_COUNT, numbers));
            objects.add(new Class2(BUTCH_COUNT, BUTCH_COUNT * 2, numbers));
            objects.add(new Class2(BUTCH_COUNT * 2, 3 * BUTCH_COUNT + 1, numbers));
        } else {
            objects.add(new Class2(0, BUTCH_COUNT, numbers));
            objects.add(new Class2(BUTCH_COUNT, BUTCH_COUNT * 2, numbers));
            objects.add(new Class2(BUTCH_COUNT * 2, 3 * BUTCH_COUNT + 2, numbers));
        }

        for(Class2 obj : objects){
         threads.add(new Thread(obj));
        }

        for(Thread a : threads){
            a.start();
         }

        for(Thread a: threads){
            a.join();
        }

        int [] maxValues = new int[objects.size()];

        for(int i = 0; i < objects.size(); i++ ){
            maxValues[i] =  objects.get(i).getMaxValue();
        }

        // biggest number in each thread
        //System.out.println(Arrays.toString(maxValues));

        System.out.println("Biggest number in the Array is: " + findMaxValueInArray(maxValues));

    }

    private static int findMaxValueInArray(int [] maxValues){
        int a = 0;
        for(int b : maxValues){
            if(b>a){
                a =b;
            }
        }
        return a;
    }


}
