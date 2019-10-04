package Lab;

public class Name implements Comparable<Name>
{
	private String first; // First name
	private String last;  // Last name

	public Name()
	{
		this("", "");
	} // end default constructor

	public Name(String firstName, String lastName)
	{
		first = firstName;
		last = lastName;
	} // end constructor

	public void setName(String firstName, String lastName)
	{
		setFirst(firstName);
		setLast(lastName);
	} // end setName

	public String getName()
	{
		return toString();
	} // end getName

	public void setFirst(String firstName)
	{
		first = firstName; 
	} // end setFirst

	public String getFirst()
	{
		return first;
	} // end getFirst

	public void setLast(String lastName)
	{
		last = lastName;
	} // end setLast

	public String getLast()
	{
		return last;
	} // end getLast

	public void giveLastNameTo(Name aName)
	{
		aName.setLast(last);
	} // end giveLastNameTo

	public String toString()
	{
		return first + " " + last;
	} // end toString
   @Override
   public int compareTo(Name other)
   {
      int result = last.compareTo(other.last);
      
      // If last names are equal, check first names
      if (result == 0)
         result = first.compareTo(other.first);
         
      return result;
   } // end compareTo
} // end Name
