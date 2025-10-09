import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringStreamExample {
    private static final Set<String> vowel = Set.of("a", "e", "i", "o", "u");
    public static void main(String[] args) {
        String sentence = "This is a sample sentence with words like beautiful and awesome";
        int k = 3;

        List<String> collect = Arrays.stream(sentence.split("\\s+"))
                .filter(c -> countvowel(c) == k)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static long countvowel(String c) {
        Stream<Character> characterStream = c.toLowerCase().chars().mapToObj(c1 -> (char) c1).filter(a -> vowel.contains(a));
        long count = characterStream.count();
        return count;

    }
}

