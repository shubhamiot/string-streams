import java.util.stream.IntStream;

public class ReverseString {

    public static void main(String[] args) {
        String str = "hello";

        String str1 = reverString(str);
        System.out.println(str1);

    }

    private static String reverString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while (left <  right){
            char temp = charArray[left];
            charArray[left]= charArray[right];
            charArray[right]= temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
