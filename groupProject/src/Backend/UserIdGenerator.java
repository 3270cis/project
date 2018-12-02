package Backend;

public class UserIdGenerator {
	
	private static int nextAvailableId;
	
	public static int generateID() {
		
		int id = nextAvailableId;
		nextAvailableId++;
		return id;
		
	}

}
