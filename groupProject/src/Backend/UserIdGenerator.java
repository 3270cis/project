package Backend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class UserIdGenerator {
	
	private static int nextAvailableId;
	
	public static int generateID() {
		
		int id = ++nextAvailableId;
		
		return id;
		
	}
	
 /* public static void main(String[] args) {
	
	  
	  
	 
  }
  
  private AtomicInteger atom1;
  
	public int getUniqueID() {
		
	 return atom1.getAndIncrement();
		 
}*/
	  
	/*AtomicInteger atom = new AtomicInteger(0);
	ExecutorService exser = Executors.newFixedThreadPool(2);
	IntStream.range(0, 9999)
		.forEach( i -> exser.submit(atom::incrementAndGet));
	
	stop(exser);
	
	System.out.println(atom.get());
	
	 
	}*/


}
