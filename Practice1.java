import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice1 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 3, 4, 5);
        Integer reduce = integers.stream()
                .reduce(3, Integer::sum);
        System.out.println(reduce);


        //count frequencey of each chracter
        String s ="programming";
        Map<Character, Long> collect = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Map.Entry<Character, Long> c : collect.entrySet()){
            System.out.println(c.getKey() + " " + c.getValue());
        }


        // rever the sting
        String s1 = "hello";
        char[] charArray = s1.toCharArray();
        String s2 = reverseString(charArray);
        System.out.println(s2);

        //count vowel in string
        String s3 = "intevieww";
        long count = countvowels(s3);
        System.out.println("vowel"+ count);
        long count1 = coutConsonet(s3);
        System.out.println("consonent" + count1);

        //remove dublicate from string
        String s4 = "programming";
        String dublicate = removeDublicates(s4);
        System.out.println("dublicate " + dublicate);


        //check string is palindrom
        String s5 = "madam";
        boolean check = checkPalidrome(s5);
        System.out.println(check);
        boolean check1 = checkPalidrome1(s5);
        System.out.println(check1);

        //first not repeating character
        String s6 = "swiss";
        Character c = firstNonRepeatedCharacter(s6);
        System.out.println("first non occurence of character" + c);

        //find dublicate element
        String s7 = "programming";
        List<Character> characters = dublicateElement(s7);
        System.out.println("dublicate character: " + characters);

        // find longest word in a string
        String s8 = "my name is shubham";
        String s9 = longestWordInSting(s8);
        System.out.println("longest word: " + s9);

        // find the frequence of each word in string
        String s10 ="java java hi hi i am shubham";
        Map<String, Long> collect1 = Arrays.stream(s10.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Map.Entry<String, Long> m : collect1.entrySet()){
            System.out.println(m.getKey() + " "+ m.getValue());
        }

        //count uppper character in a spring
        String s11 = "javaBackendDD";
        long count2 = s11.chars().filter(c2-> Character.isUpperCase(c2)).count();
        System.out.println("count of upper character" + count2);

        // check is two string are anagram
        String s12="listen", s13="silent";
        boolean checkAnagram = chechAnagram(s12, s13);
        System.out.println("anagram" + checkAnagram);


        //find word having vowe in it max 2
        String s14 = "java is god for programming";
        List<String> strings = checkVowelContainingWord(s14);
        System.out.println("vowel word:"+ strings.toString());
    }

    private static List<String> checkVowelContainingWord(String s14) {

        String[] split = s14.split("\\s+");
        String vowel = "aeiou";
        List<String> collect = Arrays.stream(split)
                .filter(c -> countVowelInString(c,vowel) == 2)
                .collect(Collectors.toList());
        return collect;
    }

    private static long countVowelInString(String c, String vowel) {

        return c.toLowerCase().chars()
                .filter(c1 -> vowel.indexOf(c1)!=-1)
                .count();
    }

    private static boolean chechAnagram(String s12, String s13) {

        Map<Character, Integer> hmap= new HashMap<>();
        for(Character c : s12.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }

        for(Character c1 : s13.toCharArray()){
            if(!hmap.containsKey(c1)) return false;
            hmap.put(c1, hmap.get(c1)-1);
            if(hmap.get(c1)==0) {
                hmap.remove(c1);
            }
        }
        return hmap.isEmpty();
    }

    private static String longestWordInSting(String s8) {
        Optional<String> reduce = Arrays.stream(s8.split(" ")).max(Comparator.comparing(String::length));
        return reduce.get();
    }

    private static List<Character> dublicateElement(String s7) {

        return s7.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 0)
                .map(c -> c.getKey())
                .collect(Collectors.toList());
    }

    private static Character firstNonRepeatedCharacter(String str) {
        Map<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        return collect.entrySet()
                .stream()
                .filter(c -> c.getValue()==1)
                .map(c ->c.getKey())
                .findFirst()
                .orElse(null);
    }

    private static boolean checkPalidrome1(String s5) {

        int left = 0;
        int right = s5.length()-1;
        while(left<right){
            if(s5.charAt(left)!=s5.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    private static boolean checkPalidrome(String s5) {

        boolean equals = s5.equals(new StringBuffer(s5).reverse().toString());
        return equals;
    }

    private static String removeDublicates(String s4) {

        String collect = s4.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        return collect;
    }

    private static long coutConsonet(String s3) {

        return s3.chars()
                .filter(c -> "aeious".indexOf(c)==-1)
                .count();
    }

    private static long countvowels(String s3) {

        return s3.chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

    private static String reverseString(char[] str) {
        int left =0;
        int right = str.length-1;
        while (left<right){
            char temp = str[left];
            str[left]= str[right];
            str[right]= temp;

            left++;
            right--;

        }

        return new String(str);
    }
}
