

public abstract class Beverage {
		
	private SIZE size;
		private String name;
		private TYPE type;
	
		private double basePrice =2.0;
		private double sizePrice = 1.0;
		
		
		public Beverage(String n, TYPE t, SIZE s){
			
			name = n;
			type = t;
			size = s;
			
			
		}
		
		public abstract double calcPrice(); 
			
			
			
		
		
		public String toString() {
			
			return name + " " + size;
		}
		
		public boolean equals(Beverage bev) {
			
			
			if(name.equals(bev.getBevName()) && type == bev.getType() && size == bev.getSize()) {
				
				return true;
			}
			
			else {
				
				return false;
			}
			
			
			
		}
		
		 
		public void setName(String n) {
			
			name = n;
			
		}
		
		public void setType(TYPE t) {
			
			type = t;
			
		}
		
		public void setSize(SIZE s) {
			
			size = s;
			
		}
		
		public SIZE getSize() {
			
			return size;
		}
		
		public String getBevName() {
			
			return name;
		}
		
		public TYPE getType() {
			
			return type;
		}
		
		public double getBasePrice() {
			
			return basePrice;
			
		}
		
		public double getSizePrice() {
			
			return sizePrice;
		}
}

