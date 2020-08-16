package mathAndLogic;

public class FindPrimesWithinRange {
	public static void main(String[] args) {
		
	}
	
	private boolean[] primesList(int maxNum) {
		boolean[] notPrimeFlags = 	new boolean[maxNum+1] ;
		
		int count=0;
		int prime = 2;
		while(prime<Math.sqrt(maxNum)) {
			clearAllForPrime(notPrimeFlags,prime);
			prime = newxPrime(notPrimeFlags, prime);
		}
		return notPrimeFlags;
	}

	private void clearAllForPrime(boolean[] notPrimeFlags, int prime) {
		/* Cross off remaining multiples of prime. We can start with (prime*prime),
		* because if we have a k * prime, where k < prime, this value would have
		* already been crossed off in a prior iteration. */
		for( int i=prime*prime;i<notPrimeFlags.length;i+=prime) {
			notPrimeFlags[i] = true; 
		}
	}

	private int newxPrime(boolean[] notPrimeFlags, int prime) {
		int next = prime + 1;
		while (next < notPrimeFlags.length && notPrimeFlags[next]) {
			next++;
		}
		return next;
	}
}
