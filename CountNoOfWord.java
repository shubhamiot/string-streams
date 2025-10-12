import java.util.Arrays;
import java.util.stream.Stream;

public class CountNoOfWord {

    public static void main(String[] args) {
        String word = "My name is shubham";
        long word1 = noOfWords(word);
        System.out.println(word1);
    }

    private static long noOfWords(String word) {

//        String[] split = word.trim().split("\\s+");
//        return split.length;

        long count = Arrays.stream(word.trim().split("\\s+")).count();
        return count;
    }
}
