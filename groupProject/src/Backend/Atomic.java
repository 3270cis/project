package Backend;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	
	  private static AtomicInteger atom1;
	  
	public static int getUniqueID() {
			
		
		 return atom1.getAndIncrement();
			 
	}
	
	
	public static void main(String[] args) {
		
		User u1 = new Customer("Hello", "World");
		User u2 = new Customer("Hello1", "World1");
		User u3 = new Customer("Hello2", "World2");
		
		
	 System.out.println(u1.getUserID());
	 System.out.println(u2.getUserID());
	 System.out.println(u3.getUserID());
	 
	 
		
	}

}

