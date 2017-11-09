
public class CitiesArray {

	// returns true if city is legit, i.e. only letters and spaces,
	// false otherwise
	public static boolean isLegit(String city) {
		for (int i=0; i < city.length(); i++) {
			char ch = city.charAt(i);
			if (!(Character.isLetter(ch) || ch == ' ')) {
				return false;
			}
		}
		return city.length() > 0;
		
	}
	
	// reads city name from user, and returns after checking for
	// legitimacy; if not legit, keeps asking user until they type
	// a legit city name
	public static String getCity() {
		String city;
		String prompt="Enter city name (letters and spaces ONLY, " +
						"at least one character), " +
						"'quit' to stop: ";
		do {
			System.out.print(prompt);
			city = IO.readString();
		} while (!isLegit(city));
		return city;
	}
	
	// adds the given city to the master cities array (which has n cities in it)
	// returns n+1 if city is added, n if city already exists (and is not added)
	public static int add(String[] cities, int n, String city) {
		
		for (int i=0; i < n; i++) {
			String nextCity = cities[i];
			
			//System.out.println("city = " + city + ", nextCity = " + nextCity);
			
			int c = city.compareToIgnoreCase(nextCity);
			if (c == 0) {
        		return n;  // city already in list, nothing to do, return n
        	}
			if (c > 0) { // keep going
				continue;    // skip everything else in this iteration and continue with the next
			}
			
			// insert at position i, need to move cities[i..n-1] one spot over to the right
			for (int k=n-1;k >= i;k--) {
				cities[k+1] = cities[k];
			}
			cities[i] = city;  // write new city in
			return n+1;
		}
		
		cities[n] = city;
		return n+1;  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cities = new String[5];   // allocate an array of length 5
		
		String city=getCity();
		int n=0;
		while (!"quit".equalsIgnoreCase(city)) {
			n = add(cities,n,city);   // n is the number of city names in cities array
			printArray(cities);
			city = getCity();
		}

	}
	
	public static void printArray(String[] arr) {
		if (arr.length == 0) {
			return;
		}
		System.out.print("[");
		System.out.print(arr[0]);
		for (int i=1; i < arr.length; i++) {
			System.out.print("," + arr[i]);
		}
		System.out.println("]");
	}


}
