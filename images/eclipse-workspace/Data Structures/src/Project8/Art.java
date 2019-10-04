package Project8;

public class Art implements Comparable<Art> {

	private String artistName;
	private int artistID;
	private int artID;
	private String title;
	private int appraisal;
	
	public Art(int artistID, int artID, String title, int appraisal){
		
		this.artistID = artistID;
		this.artID = artID;
		this.title = title;
		this.appraisal = appraisal;
	}
	public String getArtistName()
	{
		return artistName;
	}
	public void setArtistName(String artistName)
	{
		this.artistName = artistName;
	}
	public int getArtistID() {
		return artistID;
	}
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	public int getArtID() {
		return artID;
	}
	public void setArtID(int artID) {
		this.artID = artID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAppraisal() {
		return appraisal;
	}
	public void setAppraisal(int appraisal) {
		this.appraisal = appraisal;
	}
	public String toString(){
		
		return String.format("%-15s%-22s%-20s%-40s%-10s","ID: "+this.getArtistID(),"Artist: "
				+this.getArtistName(),"Art ID: "+this.getArtID(),"Title: "+this.getTitle(),"Value: "+this.getAppraisal());	}
	@Override
	public int compareTo(Art other) {
		int result = Integer.compare(artistID, other.artistID);
		
		if(result == 0)
			result = Integer.compare(artID, other.artID);
		
		return result;
	}
}
