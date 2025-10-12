public class CountVowelAndConsonent {

    public static void main(String[] args) {
        String str = "interview";

        countVowelAndConsonent(str);
    }

    private static void countVowelAndConsonent(String str) {

        String vowel="aeiou";
        long v = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .filter(c -> vowel.indexOf(c) != -1)
                .count();
        long consonent = str.chars()
                .mapToObj(c -> (char) c).filter(Character::isLetter)
                .filter(c -> vowel.indexOf(c) == -1).count();
        System.out.println(v + " " + consonent);
    }
}
