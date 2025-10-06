import java.util.*;
public class GroupEmail {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("john.shubham@gmail.com",
                "johnshubham@gmail.com",
                "john+work@gmail.com",
                "j.ohn+spam@gmail.com",
                "alex@outlook.com",
                "alex+test@outlook.com");

        List<List<String>> gropEmail = groupEmail(list);
        System.out.println(gropEmail);
    }

    private static List<List<String>> groupEmail(List<String> list) {
        Map<String, List<String>> m = new HashMap<>();
        for(String email : list){
            String s = normalizeEmail(email);
            m.computeIfAbsent(s, k -> new ArrayList<>()).add(email);
        }
        return new ArrayList<>(m.values());
    }

    private static String normalizeEmail(String email) {

        String[] split = email.split("@");
        String local = split[0];
        String domain = split[1];
        if(local.contains("+")){
            local = local.substring(0, local.indexOf("+"));
        }

        local = local.replace(".", "");
        return local + "@" + domain;
    }
}
