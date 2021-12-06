
public class Alcohol extends Beverage{
	
	
	private boolean weekend;
	private double weekendFee = .6;
	
	
	public Alcohol(String n, SIZE s, boolean w) {
		
		super(n, TYPE.ALCOHOL, s);
		
		weekend = w;
		
		
	}
	
	public String toString() {
		
		String str = getBevName() + " " + getSize();
		
		if(weekend) {
			
			str+= "weekend"; 
		}
		
		str += " " + calcPrice();
		
		return str;
	}
	
	public boolean equals(Alcohol alc) {
		
		if(super.equals(alc) && weekend == alc.getWeekend()) {
			
			return true;
		}
		else
		{
			return false;
			
		}
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
			
		}
		else if (super.getSize() ==SIZE.LARGE) {
			
			price += 2* super.getSizePrice();
			
		}
		
		if (weekend) {
			
			price+= weekendFee;
		}
		
		return price;
		
	}
	
	public void setWeekend(boolean w) {
		weekend = w;
		
	}
	
	public boolean getWeekend() {
		return weekend;
		
	}
	
	public double getWeekendFee() {
		
		return weekendFee;
	}
}