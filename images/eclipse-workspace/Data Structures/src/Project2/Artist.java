// Jason Nichols-Allen  CIS 211

package Project2;

public class Artist
	{
		private int artistID;
		private String artistName;
		
		public Artist()
		{
		
		}
		public Artist(int artistID, String artistName)
		{
			this.artistID = artistID;
			this.artistName = artistName;
		}
		public int getArtistID()
		{
			return artistID;
		}
		public String getArtistName()
		{
			return artistName;
		}
		public void setArtistID(int artistID)
		{
			this.artistID = artistID;
		}
		public void getArtistName(String artistName)
		{
			this.artistName = artistName;
		}
		
		public String toString()
		{
			return artistName+" "+artistID;
		}
}
