public class CheckStringContainsDigit {

    public static void main(String[] args) {
        String str = "1a345";
        boolean checkDigit = checkStringDigit(str);
        System.out.println(checkDigit);
    }

    private static boolean checkStringDigit(String str) {

        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
