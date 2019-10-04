package Exam3;

public class Artist implements Comparable<Artist>
	{
		private int artistID;
		private String artistName;
		private int artID;
		private String artName;
		private int appraisal;
		
		public Artist()
		{
		
		}
		public Artist(int artistID, String artistName)
		{
			this.artistID = artistID;
			this.artistName = artistName;
			artID = 0;
			artName = null;
			appraisal = 0;
		}
		public int getArtistID()
		{
			return artistID;
		}
		public String getArtistName()
		{
			return artistName;
		}
		public int getArtID(){
			
			return artID;
		}
		public String getArtName(){
			
			return artName;
		}
		public int getAppraisal(){
			
			return appraisal;
		}

		public void setArtistID(int artistID)
		{
			this.artistID = artistID;
		}
		public void setArtistName(String artistName)
		{
			this.artistName = artistName;
		}
		public void setArtID(int artID)
		{
			this.artID = artID;
		}
		public void setArtName(String artName)
		{
			this.artName = artName;
		}
		public void setAppraisal(int appraisal)
		{
			this.appraisal = appraisal;
		}
		public String toString()
		{
			return String.format("%-15s%-22s%-20s%-40s%-10s","ID: "+this.getArtistID(),"Artist: "
					+this.getArtistName(),"Art ID: "+this.getArtID(),"Title: "+this.getArtName(),"Value: "+this.getAppraisal());
		}
		@Override
		public int compareTo(Artist other) {
			
			int result = Integer.compare(artistID, other.artistID);
			
			if(result == 0)
				result = Integer.compare(artID, other.artID);
			
			return result;
		}
}
