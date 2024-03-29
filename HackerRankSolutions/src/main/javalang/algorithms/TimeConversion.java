package javalang.algorithms;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 * Time Conversion
 */
public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String hours = s.substring(0,2);
        String ind = s.substring(8,10);
        if(ind.equals("AM")){
            return s.substring(0,8);
        }else{
            int intHours = Integer.parseInt(hours);
            intHours +=12;
            return intHours + s.substring(2,8);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}
