package examples;

public class Person_v2 {
    private String name;
    private Address address;

    /* General constructor */
    public Person_v2(String name) {
        this.name = name;
    }

    public Person_v2(String name, Address address) {
        this(name); // call general constructor
        setAddress(address);
    }

    public String toString() {
        return String.format("%s - %s", getName(), getAddress());
    }

    public boolean equals(Object o) {
        if (!(o instanceof Person_v2)) {
            return false;
        } else {
            Person_v2 other = (Person_v2) o;
            return name.equals(other.name);
        }
    }

    /* Setter and Getter methods */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
