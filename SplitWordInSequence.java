import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitWordInSequence {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java is fun", "My name is shubham");
        List<String> collect = list.stream().flatMap(c -> Arrays.stream(c.split(" ")))
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> list1 = Arrays.asList("ahubham", "a", "a", "shu", "shu");
        List<String> collect1 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

    }

}
