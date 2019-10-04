package Exam3;

public class ArtistWork extends Art implements Comparable<Art> {

	protected String artistName;

	public ArtistWork(int artistID, String artistName, int artID, String title, int appraisal) {
		super(artistID, artID, title, appraisal);
		this.artistName = artistName;
	}
	public void setArtistName(String artistName){
		this.artistName = artistName;
	}
	public String getArtistName(){
		return artistName;
	}
	public String toString()
	{
		return String.format("%-15s%-22s%-20s%-30s%-10s","ID: "+this.getArtistID(),"Artist: "
				+this.getArtistName(),"Art ID: "+this.getArtID(),"Title: "+this.getTitle(),"Value: "+this.getAppraisal());
	}
	@Override
	public int compareTo(Art other) {
		int result = Integer.compare(artistID, other.artistID);
		
		if(result == 0)
			result = Integer.compare(artID, other.artID);
		
		return result;
	}
}
