package streamAndLambda;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;
import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        String arr[] = {"a","b","c","d"};
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        out.println(list.stream().filter(str -> str.equals("a")).collect(toList()));
        list.stream().map( str -> str.toUpperCase()).collect(toList()) ;
        out.println(list.stream().map( str -> str.toUpperCase()).collect(toList()));
        out.println(list);
    }
}
