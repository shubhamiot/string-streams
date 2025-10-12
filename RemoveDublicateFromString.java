import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDublicateFromString {

    public static void main(String[] args) {
        String str = "programming";
        String str2 = removeDublicate(str);
        String str3 = removeDublicateUsingHashSet(str);
        System.out.println(str2);
        System.out.println(str3);
    }

    private static String removeDublicateUsingHashSet(String str) {

        Set<Character> hset = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c: str.toCharArray()){
            char lowerCase = Character.toLowerCase(c);
            if(!hset.contains(lowerCase)){
                hset.add(lowerCase);
                stringBuilder.append(c);
            }

        }
        return stringBuilder.toString();
    }

    private static String removeDublicate(String str) {
        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
