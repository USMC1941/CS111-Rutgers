package examples;

public class AddressBookApp {

    public static void main(String[] args) {
        AddressBook aBook = new AddressBook(10);

        Address a = new Address(2, "Maple St", "New York", "NY", 10201);
        Person_v2 p = new Person_v2("Mary", a);
        aBook.addLinear(p);

        a = new Address(678, "145th St", "New York", "NY", 10600);
        p = new Person_v2("Paul", a);
        aBook.addLinear(p);

        a = new Address(45, "Pitt St", "Nyack", "NY", 11670);
        p = new Person_v2("John", a);
        aBook.addLinear(p);

        a = new Address(783, "Main St", "Port Jefferson", "NY", 16402);
        p = new Person_v2("Tim", a);
        aBook.addLinear(p);

        a = new Address(523, "Pine St", "New Brunswick", "NJ", 18901);
        p = new Person_v2("Tom", a);
        aBook.addConstant(p);

        System.out.println(aBook);

        aBook.removeShift("John");
        System.out.println(aBook);

        aBook.removeReplace("Paul");
        System.out.println(aBook);
    }
}
