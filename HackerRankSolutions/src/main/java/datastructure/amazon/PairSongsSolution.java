package datastructure.amazon;
import java.util.ArrayList;
import java.util.List;

public class PairSongsSolution {

	public static void main(String[] args) {
		int rideDuration=100;
		ArrayList<Integer> songDurations = new ArrayList();
		songDurations.add(30);
		songDurations.add(40);
		
		PairSongsSolution p = new PairSongsSolution();
		ArrayList<Integer> result = p.IDsOfSongs(rideDuration, songDurations);
		System.out.println(result.toString());
		
	}
	// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED
	// CLASS BEGINS, THIS CLASS IS REQUIRED

		// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	private static final Integer TIME_BEFORE_STOP = 30;
	ArrayList<Integer> IDsOfSongs(int rideDuration, 
	                              ArrayList<Integer> songDurations)
	{
		// WRITE YOUR CODE HERE
		//Apply some validations. List size must be greater than 1
		if(songDurations == null || songDurations.size()<2){
		   System.out.println("Songs List size must be greater than 1");

		    throw new IllegalArgumentException("Songs List size must be greater than 1");
		}
		if(rideDuration <=0){
		   System.out.println("Ride Duration must be greater than 0");
		   throw new IllegalArgumentException("Ride Duration must be greater than 0");
		}
		//1- Define the output list variable
		ArrayList<Integer> optimalPair = new ArrayList<>();
		int maxOptimalSongDuration =0;
		//Start looping through the Songs, to find the optimalPairs
		int targetDuration = rideDuration - TIME_BEFORE_STOP;
		int songTargetDuration;
		int pairMaximumSong;
		for(int i=0;i<songDurations.size()-1;i++){
		    songTargetDuration = targetDuration - songDurations.get(i);
		    //If the first song's length exceeds the trip duration, skip to next song
		    if(songTargetDuration <=0){
		        continue;
		    }
		    //Now search in the remaining songs for the second song that matches this songDuration
		    for(int k=i+1; k <songDurations.size();k++){
		        if(songDurations.get(k) == songTargetDuration){
		            // A match was found
		            pairMaximumSong = Math.max(songDurations.get(i), songDurations.get(k));
		        	if(pairMaximumSong > maxOptimalSongDuration) {
		        		optimalPair.clear();
			        	optimalPair.add(i);
			        	optimalPair.add(k);
			        	maxOptimalSongDuration =pairMaximumSong;
		        	}
			        	
		        }
		    }
		}
		return optimalPair;
	}
		// METHOD SIGNATURE ENDS
}