
public class Coffee extends Beverage {

	private boolean extraShot;
	private boolean extraSyrup;
	private double costShot = .5;
	private double costSyrup = .5 ;
	
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super (n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
		
		
	}
	
	
	public String toString() {
		
		String s = getBevName() + " "+ getSize();
		
		if (extraShot) {
			
			s +="Extra Shot";
			
		}
		
		if (extraSyrup) {
			
			s += "Extra Syrup";
		}
		
		s += " $" + calcPrice();
		
		return s;
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			
			price += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			
			price += 2*super.getSizePrice();
		}
		
		
		if(extraShot) {
			
			price += costShot;
			
		}
		
		if(extraSyrup) {
			
			price += costSyrup;
			
		}
		
		return price;
		
	}
	
	public boolean equals(Coffee cof) {
		
		if (super.equals(cof) && extraShot == cof.getShot() && extraSyrup == cof.getSyrup()) {
			
			return true;
		}
		else {
			
			return false;
			
		}
		
		
	}
	
	public void setShot(boolean shot) {
		
		extraShot = shot;
	}
	
	public void setSyrup (boolean syrup) {
		
		extraSyrup = syrup;
		
	}
	
	public boolean getShot() {
		
		return extraShot;
		
	}
	
	public boolean getSyrup () {
			
			return extraSyrup;
		}
	
	public double getSHotCost() {
			
			return costShot;
		}
		
	
	public double getSyrupCost() {
		
		return costSyrup;
	}

	
}
