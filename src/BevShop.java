import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	
	private int numAlc;
	private int CurrentOrder;
	private ArrayList<Order> orders;
	
	public BevShop() {
		
		orders = new ArrayList<>();
		
	}

	
	

	

	
	public String toString() {
		
		String s = "Monthly Order \n";
		
		for (Order o: orders) {
			
			s +=o.toString();
			
		}
		
		s+= "total sale: "+ totalMonthlySale();
		
		
		return s;
	}
	
	@Override
	public boolean validTime(int time) {
		// TODO Auto-generated method stub
	if (time >= MIN_TIME && time <= MAX_TIME) {
				
				return true;
			}
			
			return false;
		}
	@Override
	public boolean eligibleForMore() {
		// TODO Auto-generated method stub
		if (numAlc < MAX_ORDER_FOR_ALCOHOL) {
			
			return true;
		}
		
		return false;
	}
	@Override
	public boolean validAge(int age) {
		// TODO Auto-generated method stub
		if (age > MIN_AGE_FOR_ALCOHOL) {
				
				
				return true;
				
				
			}else {
			
			return false;
			
			}
	}
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		// TODO Auto-generated method stub
		
		Customer cust = new Customer(customerName, customerAge);
		
		Order order = new Order(time, day, cust);
		orders.add(order);
		
		{
			CurrentOrder = orders.indexOf(order);	
		
		numAlc = 0;
		}
	}
	public boolean isMaxFruit(int n) {
		
		if (n > MAX_FRUIT) {
			return true;
		}
		
		return false;
	}
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		
		orders.get(CurrentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		// TODO Auto-generated method stub
		
		orders.get(CurrentOrder).addNewBeverage(bevName, size);
		numAlc++;
	}
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		// TODO Auto-generated method stub
			
		orders.get(CurrentOrder).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	@Override
	public int findOrder(int orderNo) {
		// TODO Auto-generated method stub
		
		
		for (int q = 0; q < orders.size(); q++) {
			
			if(orders.get(q).getOrderNo() == orderNo) {
				
				return q;
			}
		}
		
		
		return -1;
		
	}
	@Override
	public double totalOrderPrice(int orderNo) {
		// TODO Auto-generated method stub
		
		double oS = 0;
		for (Order o : orders) {
			if (o.getOrderNo() == orderNo) {
				
				for (Beverage b: o.getBeverages()) {
					
					oS += b.calcPrice();
				}
			}
			
			
		}
		
		return oS;
	}
	@Override
	public double totalMonthlySale() {
		// TODO Auto-generated method stub
		
		double tMS = 0;
		
		for (Order o : orders) {
			
			for (Beverage b : o.getBeverages()) {
				
				tMS += b.calcPrice();
			}
		}
		return tMS;
	}
	@Override
	public void sortOrders() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < orders.size(); i++) {
			
			int min = i;
			
			for (int q = i+1; q < orders.size(); q++) {
				
				if(orders.get(q).getOrderNo() < orders.get(min).getOrderNo()) {
					
					min = q;
				}
			}
			
			Order weKnow = orders.get(min);
			
			orders.set(min, orders.get(i));
			
			orders.set(i,  weKnow);
			
			
		}
	}
	
	public Order getCurrentOrder() {
			
			return orders.get(CurrentOrder);
			
			
		}
	@Override
	public Order getOrderAtIndex(int index) {
		// TODO Auto-generated method stub
		return orders.get(index);
	}
	
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
		
	}
	
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}
	public int totalNumOfMonthlyOrders() {
		
		return orders.size();
	}

	
	public int getNumOfAlcoholDrink() {
		return numAlc;
		
	}
	
}
