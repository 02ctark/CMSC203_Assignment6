
public class Smoothie extends Beverage{

	
	private int numOfFruits;
	private boolean addProtein;
	private double costFruit = .5;
	private double costProtein = 1.5;
	
	public Smoothie (String n , SIZE s, int ft, boolean p){
		super(n, TYPE.SMOOTHIE, s);
		numOfFruits = ft;
		addProtein = p;
		
		
		
	}
	
	public String toString() {
		
		String s = getBevName() + " " + getSize() + " " + numOfFruits + " Fruits";
		
		if(addProtein) {
			
			s += "Protein powder";
		}
		
		s += " $" + calcPrice();
		
		
		return s;
		
		
		
	}
	
	public boolean equals(Smoothie smo) {
		
		if(super.equals(smo) && numOfFruits == smo.getNumOfFruits() && addProtein == smo.getAddProtein())
		{
			
			return true;
		}
		
		else 
		{
		return false;
		}
		
	}
	
	public double calcPrice() {
		
		double price = super.getBasePrice();
		
		
		if(super.getSize() == SIZE.MEDIUM){
			
			price += super.getSizePrice();
		}
		
		else if (super.getSize() == SIZE.LARGE) {
			
			price += 2* super.getSizePrice();
			
		}
		
		price += numOfFruits * costFruit;
		
		if(addProtein) {
			
			price += costProtein;
		}
				
		return price;
	}
	
	
	
	
	
	
		public void setNumFruits (int ft) {
			numOfFruits = ft;
			
		}
		
		public void setAddProtein(boolean p) {
			
			addProtein = p;
			
		}
		
		public int getNumOfFruits() {
			
			return numOfFruits;
		}
		


		public boolean getAddProtein() {
			
			return addProtein;
		}
		
		public double getCostFruits() {
			
			return costFruit;
		}
		
		public double getCostProtein() {
			
			return costProtein;
		}
			
		
		
}
