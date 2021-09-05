public class Cities {

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
                        + "'quit' to stop";
        do {
            System.out.print(prompt);
            city = IO.readString();
        } while (!isLegit(city));
        return city;
    }

    /** adds the given city to the master cities string and returns the updated cities string */
    public static String add(String cities, String city) {
        return "";
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
