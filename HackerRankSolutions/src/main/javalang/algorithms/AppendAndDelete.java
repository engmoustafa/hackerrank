package javalang.algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 */
public class AppendAndDelete {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        char[] cS = s.toCharArray();
        char[] cT = t.toCharArray();
        //if(s.equals(t) && k < cS.length *2 && k%2==1){
        //    return "No";
        //}
        int index = 0;
        boolean stop = false;
        do{
            if (index > cS.length-1 || cT[index]!=cS[index])
                break;
            index++;
        }while(index <cT.length && !stop);

        int deleteOperations = cS.length - index ;
        int addOperations = cT.length - index ;
        if( deleteOperations + addOperations  == k )
            return "Yes";
        else if (k<deleteOperations + addOperations)
            return "No"  ;
        else {
            int diff = k -deleteOperations - addOperations;
            if (diff%2 == 0){
                return "Yes";
            }
            if(k < (cS.length + cT.length)){
                return "No";
            }else{
                return "Yes";
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        scanner.close();
    }
}
