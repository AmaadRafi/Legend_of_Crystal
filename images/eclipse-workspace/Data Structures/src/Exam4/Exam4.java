package Exam4;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {

		step1();
		step2();
		step3();
		step4();
	}
	public static void step1(){
		
		ArtMap arts = new ArtMap("exam4arts.txt");
		Scanner input = new Scanner(System.in);
		Boolean running = true;
		
		System.out.println("===================== Locate Artist ID ============================");
		while(running){
			
			System.out.print("Please enter an ID number (0 to quit): ");
			int ID = input.nextInt();
			
				if(ID != 0){
				
					try {
						int artistID = arts.getID(ID);
						System.out.println("Artist: "+artistID+"\n");
					} catch (Exception e) {
						System.out.println("Artist not found");
					}
				}
				else{
					running = false;
					System.out.println("\nBye!\n");
				}
		}
	}
	public static void step2(){
		
		MyArtists artists = new MyArtists("exam4artists.txt");
		Scanner input = new Scanner(System.in);
		Boolean running = true;
		
		System.out.println("===================== Locate Artist ============================");
		while(running){
			
			System.out.print("Please enter an ID number (0 to quit): ");
			int ID = input.nextInt();
			
			if(ID != 0){
				
				try {
					String name = artists.getID(ID).toString();
					System.out.println(name+"\n");
				} catch (Exception e) {
					System.out.println("Artist not found");
				}
			}
			else{
				running = false;
				System.out.println("\nBye!");
			}
		}
	}
	public static void step3(){
		
		MyArtWorks artists = new MyArtWorks("exam4arts.txt");
		
		artists.print("Jason Nichols-Allen\tExam 4", "exam4out3.txt");
	}
	public static void step4(){
		
		MyArtWorks artists = new MyArtWorks("exam4arts.txt");
		Scanner input = new Scanner(System.in);
		Boolean running = true;
		
		System.out.println("===================== Locate Artist Data ============================");
		while(running){
			
			System.out.print("Please enter an ID number (0 to quit): ");
			int ID = input.nextInt();
			
			if(ID != 0){
				
				try {
					artists.print(ID-1);
				} catch (Exception e) {
					System.out.println("Artist not found");
				}
			}
			else{
				running = false;
				System.out.println("\nBye!");
			}
		}
	}
}
