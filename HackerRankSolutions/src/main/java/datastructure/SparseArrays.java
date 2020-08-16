package datastructure;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SparseArrays {
	static class StringKeeper implements Comparable<StringKeeper>{
		String value;
		int index;
		public StringKeeper(String value, int index) {
			this.value= value;
			this.index = index;
		}
		
		
		public int compareTo(StringKeeper second) {
			// TODO Auto-generated method stub
    		return this.value.compareTo(second.value);
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return value.equals(((StringKeeper)obj).value);
		}
	}
	 // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
    	// n
    	List<StringKeeper> myStrings = new ArrayList();
    	for(int i=0;i<strings.length;i++) {
    		myStrings.add(new StringKeeper(strings[i],i));
    	}
    	
    	//n log n sorting
    	Comparator<StringKeeper> myCom = (firstStr,secondStr)->{
    		return firstStr.compareTo(secondStr);
    	};
    	myStrings.sort(myCom);
    	
    	int counter;
    	int firstIndex;
    	//Arrays.sort(queries);//m log(m)
    	List<StringKeeper> myQueries = new ArrayList();
    	for(int i=0;i<queries.length;i++) {
    		myQueries.add(new StringKeeper(queries[i],i));
    	}
    	myQueries.sort(myCom);
    	
    	int startSearch = 0, compareResult = 0;
    	int[] results  = new int[queries.length];
    	for(int i=0;i<myQueries.size();i++) {
    		counter = 0;
    		if(i> 0 && myQueries.get(i).equals(myQueries.get(i-1))) {
    			results[myQueries.get(i).index] = results[myQueries.get(i-1).index] ;
    			continue;
    		}
        	//myStrings.indexOf(new StringKeeper(queries[i],-1));
    		for(int j=startSearch;j<myStrings.size();j++) {
    			compareResult=myQueries.get(i).compareTo(myStrings.get(j));
    			if(compareResult==0) {
    				counter ++;
    			}else if(compareResult<0) {
    				startSearch = j;
    				break;
    			}
    		}
    		results[myQueries.get(i).index] = counter; 
    		
    	}
    	return results;
    	
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
