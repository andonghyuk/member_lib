package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute {
	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("동혁", 22,80));
		pList.add(new Person("동동", 52,50));
		pList.add(new Person("동현", 42,20));
		pList.add(new Person("혁동", 28,90));
		Collections.sort(pList);
		System.out.println(pList);
	}
}
