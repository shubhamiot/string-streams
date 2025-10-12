import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonReatingCharacter {

    public static void main(String[] args) {

        String str = "swiss";
        char c = firstNotRepeatingCharacter(str);
        System.out.println(c);
    }

    private static char firstNotRepeatingCharacter(String str) {
        LinkedHashMap<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Character c1 = collect.entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(c -> c.getKey())
                .findFirst()
                .orElse(null);
        return c1;

    }

}
