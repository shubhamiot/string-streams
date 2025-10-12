import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringAnagram  {

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        boolean checkAnagram = checkAnagram(s1, s2);
        System.out.println(checkAnagram);
        boolean b = checkAnagramUsingHashMap(s1, s2);
        System.out.println(b);
    }

    private static boolean checkAnagramUsingHashMap(String s1, String s2) {

        Map<Character, Integer> hmap = new HashMap<>();
        for(Character c : s1.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c, 0)+1);
        }
        for(Character c: s2.toCharArray()){
            if(!hmap.containsKey(c)) return false;

            hmap.put(c,hmap.get(c)-1);
            if(hmap.get(c)==0){
                hmap.remove(c);
            }
        }
        return hmap.isEmpty();
    }

    private static boolean checkAnagram(String s1, String s2) {

        char[] charArray = s1.toCharArray();
        char[] charArray1 = s2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        boolean equals = Arrays.equals(charArray, charArray1);
        return equals;
    }
}
