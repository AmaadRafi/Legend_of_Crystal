package project3;

public class Entry {

	private int weight;
	private String actions;
	private String name;
	private boolean A = false;	
	private boolean F = false;
	private boolean L = false;
	private boolean T = false;
	private boolean R = false;
	
	public Entry(int weight, String actions, String name) {
		this.weight = weight;
		this.actions = actions;
		this.name = name;
		
		parseActions();
	}
	public void parseActions() {
		
		for(int i = 0; i < actions.length(); i++) {
			
			switch(actions.charAt(i)) {
			
			case 'A':
				A = true;
				break;
			case 'F':
				F = true;
				break;
			case 'L':
				L = true;
				break;
			case 'T':
				T = true;
				break;
			}
		}
	}
	
	public int getWeight() {
		return weight;
	}
	public String getActions() {
		return actions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isA() {
		return A;
	}
	public boolean isF() {
		return F;
	}
	public boolean isL() {
		return L;
	}
	public boolean isT() {
		return T;
	}
	@Override
	public String toString() {
		return "Entry [weight=" + weight + ", actions=" + actions + ", name=" + name + ", A=" + A + ", F=" + F + ", L="
				+ L + ", T=" + T + "]";
	}
	
}
