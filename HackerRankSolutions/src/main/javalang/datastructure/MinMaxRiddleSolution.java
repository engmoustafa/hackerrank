package javalang.datastructure;

import java.io.FileWriter;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxRiddleSolution {
    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];
        RiddleKeeper keeper  = null;
        for (int setSize = 1; setSize < arr.length; setSize++) {
            //Start calculating
            keeper = new RiddleKeeper(setSize);
            for (int i = 0; i <= arr.length - setSize; i++) {
                keeper.add(arr[i]);


            }
        }
        return result;
    }
    private static class RiddleKeeper{
        Queue<Long> queue = new ArrayDeque<>();
        Long maxInteger = Long.MIN_VALUE, minInteger = Long.MAX_VALUE;
        Integer size = 0;
        public RiddleKeeper(int size){

        }
        public RiddleKeeper(int size, long[] initialValues){
            this.size = size;
            Arrays.stream(initialValues).forEach(it -> {
                queue.add(it);
            });
        }

        public Long add(Long newValue){
            Long result  =null;
            boolean findMax = false, findMin = false;
            if(queue.size() >= size){
                result = queue.poll();

                if(result == maxInteger && result > newValue){
                    findMax = true;
                }
                if(result == minInteger && result < newValue){
                    findMax = true;
                }
            }
            queue.add(newValue);
            if (newValue > maxInteger) {
                maxInteger = newValue;
            }
            if(newValue < minInteger) {
                minInteger = newValue;
            }
            if(findMax || findMin){
                for (Iterator<Long> iterator = queue.iterator(); iterator.hasNext(); ) {
                    Long nextInt =  iterator.next();
                    if(nextInt > maxInteger){
                        maxInteger = nextInt;
                    }
                    if(nextInt < minInteger){
                        maxInteger = nextInt;
                    }
                }
            }
            return result;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
