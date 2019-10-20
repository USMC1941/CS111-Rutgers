public class Playground {

	public static void main(String[] args) {

		Cat one   = new Cat("George", 4, 50.0, "orange", true);
		Cat two   = new Cat("George", 4, 50.0, "orange", true);
		Cat three = new Cat();


		if (one.equals(two)) {

			System.out.println("They're twins!");
		}

		System.out.println(one);
		System.out.println(three);


	}

}
