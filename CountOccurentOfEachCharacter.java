import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurentOfEachCharacter {

    public static void main(String[] args) {
        String str = "programming";
        Map<Character, Long> charCount = countCharacter(str);
        charCount.forEach((Character c, Long l) -> System.out.println(c + " " + l));
    }

    private static Map<Character, Long> countCharacter(String str) {
        return str.chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }

}
