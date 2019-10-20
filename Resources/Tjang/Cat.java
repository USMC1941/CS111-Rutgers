public class Cat {

	private String  name;
	private int     age;
	public  double  weight;
	public  String  color;
	public  boolean tail;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}

	public Cat() {
		name = "Cat";
		age = 1;
		weight = 3.0;
		color = "Black";
		tail = true;
	}

	public Cat(String name, int age, double wt, String color, boolean tail) {
		this.name = name;
		this.age = age;
		this.color = color;
		this.tail = tail;
		this.weight = wt;
	}

	public void dye(String color) {
		this.color = color;
	}

	public boolean equals(Cat c) {
		if (this.name.equals(c.name) && this.age == c.age && this.color.equals(c.color) && this.weight == c.weight && this.tail == c.tail) {
			return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		return name + " " + age + " " + weight + " " + color + " " + tail;
	}
}
