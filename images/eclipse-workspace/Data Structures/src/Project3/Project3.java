package Project3;

public class Project3 {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		UpdateArtistList update = new UpdateArtistList();
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		
		System.out.println("\nTime Elapsed: " + elapsedTime);
	}
}
