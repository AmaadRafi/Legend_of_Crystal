package Project3;

public class Artist
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
			return artistName+" "+artistID;
		}
}
