package test;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		list.add(++i);
		System.out.println(list);
		System.out.println(i);
	}
}
