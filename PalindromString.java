public class PalindromString {

    public static void main(String[] args) {
        String input = "madam";
        boolean check = checkPalindome(input);
        System.out.println(check);
    }

    private static boolean checkPalindome(String input) {

        if(input == null) return false;
        int left = 0;
        int right = input.length()-1;
        while (left<right){
            if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
