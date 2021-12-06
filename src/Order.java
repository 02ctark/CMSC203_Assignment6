import java.util.ArrayList;
import java.util.Random;

public class Order implements Comparable<Order>, OrderInterface {

	
	
	private int orderNo;
	private int orderTime;
	private DAY orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;
	
	
	public Order(int ot, DAY oD, Customer c) {
		
		orderNo = RandNumGen();
		orderDay = oD;
		cust = c;
		orderTime = ot;
		beverages = new ArrayList<>();
	}
	
	public int RandNumGen( ) {
		
		Random r = new Random();
		
		int low = 10000;
		int high = 90000;
		
		int result = r.nextInt(high - low ) + low;
		
		
		return result;
	}
	
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		Coffee cof = new Coffee(bevName, size, extraShot, extraSyrup);
		
		beverages.add(cof);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		// TODO Auto-generated method stub
		
		boolean weekend = false;
		
		if(orderDay == DAY.SUNDAY || orderDay == DAY.SATURDAY) {
			
			weekend = true;
		}
		Alcohol alc = new Alcohol(bevName, size, weekend);
		beverages.add(alc);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotein) {
		// TODO Auto-generated method stub
		
		Smoothie smo = new Smoothie(bevName, size, numOfFruits, addPRotein);
		beverages.add(smo);
	}
	
	public String toString() {
		
		String str = "___________" + orderDay.toString() + " " + orderTime + cust.toString() + 
				"\n The order number: " + orderNo;
		
		for (Beverage b : beverages) {
			
			str += "\n" + b.toString();
			
			
		}
		str += "\n The total for the order: " + calcOrderTotal(); 
		
		return str;
	}
	
	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		if (orderNo == o.getOrderNo()) {
			
			return 0;
		}
		else if (orderNo > o.getOrderNo()){
			
			return 1;
		}
		else {
			return -1;
			
		}
	}
	
	public boolean isWeekend() {
		if(orderDay == DAY.SUNDAY || orderDay == DAY.SATURDAY) {
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	
	}
	
	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		return beverages.get(itemNo);
		
	}

	@Override
	public double calcOrderTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		
		for (Beverage b: beverages) {
			
			total += b.calcPrice();
			
		}
		return total;
		
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		// TODO Auto-generated method stub
		int finger = 0;
		
		for (Beverage b: beverages) {
			
			if (b.getType() == type) {
				
				finger++;
			}
			
		}
		
		return finger;
	}
	

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalItems() {
		return beverages.size();
		
	}
	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Customer getCustomer() {
		
		return new Customer(cust);
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}



	



	
	

	
}
