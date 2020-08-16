package datastructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 * @author moustafaessa1
 *
 */
public class CastleOnTheGrid {

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	//Convert grid into Integer 2d array
    	int[][] gridInt = new int[grid.length][grid[0].length()];
    	Integer [][] gridMin = new Integer[grid.length][grid[0].length()];
    	char c;
    	for(int x =0;x<gridInt.length;x++) {
    		for(int y=0;y<gridInt[x].length;y++) {
    			c = grid[x].charAt(y);
    			if(c == '.') {
    				gridInt[x][y]=1;
    			}else {
    				gridInt[x][y]=0;
    			}
    			
    		}
    		
    	}
    	boolean notReached = true;
    	gridMin[startX][startY] = 0;
    	int currentX=startX,currentY=startY;
    	while(notReached) {
    		//Try up
    		if(currentY!=0) {
    			
    		}
    		//Try right
    		if(currentX!=gridMin.length) {
    			
    		}
    		//Try left
    		if(currentX!=0) {
    			
    		}
    		//Try down
    		if(currentY!=gridMin.length) {
    			
    		}
    	}
    	
    	return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
