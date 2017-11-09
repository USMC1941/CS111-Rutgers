package examples;

import java.util.ArrayList;

public class ArrayListUse {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("apple");
		arr.add("orange");
		for (String i : arr) {
			int index = arr.indexOf(i);
			System.out.println(index + " - " + i);
		}
		System.out.println("----- " + arr.size());
		
		arr.add(0,"pear");
		for (String i : arr) {
			int index = arr.indexOf(i);
			System.out.println(index + " - " + i);
		}
		System.out.println("----- " + arr.size());
		
		arr.remove("apple");
		for (String i : arr) {
			int index = arr.indexOf(i);
			System.out.println(index + " - " + i);
		}
		System.out.println("----- " + arr.size());
	}
}
