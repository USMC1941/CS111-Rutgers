public class Cities_1 {

    /** returns true if city is legit, i.e. only letters and spaces, false otherwise */
    public static boolean isLegit(String city) {
        for (int i = 0; i < city.length(); i++) {
            char ch = city.charAt(i);
            if (!(Character.isLetter(ch) || ch == ' ')) {
                return false;
            }
        }
        return city.length() > 0;
    }

    /**
     * reads city name from user, and returns after checking for legitimacy; if not legit, keeps
     * asking user until they type a legit city name
     */
    public static String getCity() {
        String city;
        String prompt =
                "Enter city name (letters and spaces ONLY, "
                        + "at least one character), "
                        + "'quit' to stop: ";
        do {
            System.out.print(prompt);
            city = IO.readString();
        } while (!isLegit(city));
        return city;
    }

    /** adds the given city to the master cities string and returns the updated cities string */
    public static String add(String cities, String city) {
        int start = 0;
        int pos = cities.indexOf(';');
        // pos will be -1 if no semicolon is found in the string
        while (pos != -1) {
            // city name that is in the range start..pos-1
            String nextCity = cities.substring(start, pos);

            int c = city.compareToIgnoreCase(nextCity);
            if (c == 0) {
                // city already in list, nothing to do, return cities without change
                return cities;
            }

            // c is < 0 if city < nextCity and c > 0 if city > nextCity
            if (c < 0) {
                String prefix = cities.substring(0, start); // 0..start-1
                String suffix = cities.substring(start); // start..end of string
                return prefix + city + ';' + suffix; // keep going
            }

            // c > 0, keep going
            start = pos + 1;
            // look for ';' starting at "start" index, not beginning of
            // string
            pos = cities.indexOf(';', start);
        }
        return cities + city + ";";
    }

    public static void main(String[] args) {
        String cities = ""; // cities string starts out empty
        String city = getCity();
        while (!"quit".equalsIgnoreCase(city)) {
            cities = add(cities, city);
            System.out.println(cities);
            city = getCity();
        }
    }
}
