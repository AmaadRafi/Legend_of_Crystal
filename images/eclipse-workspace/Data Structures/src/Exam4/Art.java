package Exam4;

public class Art implements Comparable<Art> {

	protected int artistID;
	protected int artID;
	protected String title;
	protected int appraisal;
	
	public Art(int artistID, int artID, String title, int appraisal){
		
		this.artistID = artistID;
		this.artID = artID;
		this.title = title;
		this.appraisal = appraisal;
	}
	public Art() {
		
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
		
		return String.format("\t%-15s%-35s%-20s","Art ID: "+this.getArtID(),"Title: "+this.getTitle(),"Value: "+this.getAppraisal());
	}
	@Override
	public int compareTo(Art other) {
		
		int result = Integer.compare(artID, other.artID);
		
		return result;
	}
}
