package streamAndLambda;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {
	public static void main(String[] args) {
		List c = Stream.of("a","b","c").map(str -> str.toUpperCase()).collect(toList());
		System.out.println(c.toString());
	}
}
