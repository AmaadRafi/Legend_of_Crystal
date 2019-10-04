package Project8;

public class Project8 {

	public static void main(String[] args) {
		
		print();
	}
	public static void print(){
		
		ArtDatabase artData = new ArtDatabase("p7artists.txt","p7arts.txt");
		artData.print("Jason Nichols-Allen\tProject 8", "p8out(JasonNicholsAllen).txt");
	}
}
