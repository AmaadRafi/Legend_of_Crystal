package Exam3;

public class Exam3 {

	public static void main(String[] args) {
		
		Step1();
		Step2();
		Step3A();
		Step3B();
	}
	public static void Step1(){
		
		MyArtistList myArtists = new MyArtistList("p7artists.txt");
		myArtists.print("Jason Nichols-Allen\tExam3 Part1", "exam3out1.txt");
	}
	public static void Step2(){
		MyArtList myArts = new MyArtList("p7arts.txt");
		myArts.print("Jason Nichols-Allen\tExam3 Part2", "exam3out2.txt");
	}
	public static void Step3A(){
		
		MyArtistNodes myArts = new MyArtistNodes("p7artists.txt");
		myArts.print();
		myArts.print("Jason Nichols-Allen\tExam3 Part3A", "exam3out3A.txt");
	}
	public static void Step3B(){
	
		MyArtCollection myCollection = new MyArtCollection("p7arts.txt");
		myCollection.print("Jason Nichols-Allen\tExam3 Part3B", "exam3out3B.txt");
	}

}
