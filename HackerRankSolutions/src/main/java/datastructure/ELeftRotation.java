package datastructure;

import java.util.Scanner;

public class ELeftRotation {

	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        String[] nd = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nd[0]);

	        int d = Integer.parseInt(nd[1]);

	        int[] a = new int[n];

	        String[] aItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int aItem = Integer.parseInt(aItems[i]);
	            a[i] = aItem;
	        }
	        
	        startRotation(a,d);
	        

	        scanner.close();
	    }
	    public static void startRotation(int[] input, int rotations) {
	    	int[] result = new int[input.length];
	    	rotations = rotations%input.length;
	    	
	    	int targetIndex;
	    	for(int i =input.length-1;i>=0;i--) {
	    		targetIndex = i-rotations;
	    		if(targetIndex<0) {
	    			targetIndex += input.length;
	    		}
	    		System.out.println("i:" + i + "  target:" +  targetIndex);
	    		
	    		result[targetIndex] = input[i];
	    	}
	    	for(int i =0;i< result.length;i++) {
	    		System.out.print(result[i] + " ");
	    	}
	    	
	    }

}
