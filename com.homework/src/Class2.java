import java.util.Arrays;

public class Class2 implements Runnable {

    public int start;
    public int end;
    public int[] numbers;
    int maxValue;


    public Class2(int start, int end, int[] numbers) {
        this.start = start;
        this.end = end;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        maxValue = findMuxValueInArray();
       }


    public int findMuxValueInArray(){
        int a = 0;
        for(int i = start; i < end; i++){
            if(numbers[i] > a){
                a = numbers[i];
            }
        }
        return a;
    }


    public int getMaxValue() {
        return maxValue;
    }

}
