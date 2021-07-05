package javalang.datastructure;

import java.io.*;
import java.util.*;

public class LargestRectangleSolution {
    public long largestRectangle(int[] h) {
        int maxSizeIt = 0;
        long largestRecSize = 0;
        long recSizeForBlock  =0;
        for (int i = 0; i < h.length; i++) {
            maxSizeIt = 1;
            if(i > 0)
                //Navigate through the previous blocks trying to find how far the selection can go
                for (int j = i -1; j >= 0  ; j--) {
                    if(h[j] < h[i] ){
                        break;
                    }
                    maxSizeIt ++ ;
                }
            if(i < h.length -1)
                //Navigate through the next blocks trying to find how far the selection can go
                for (int j = i +1; j < h.length ; j++) {
                    if(h[j] < h[i] ){
                        break;
                    }
                    maxSizeIt ++ ;
                }
            recSizeForBlock = h[i] * maxSizeIt;
            if(recSizeForBlock > largestRecSize){
                largestRecSize = recSizeForBlock;
            }
        }
        return largestRecSize;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        LargestRectangleSolution s = new LargestRectangleSolution();
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = s.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
