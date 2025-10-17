import java.util.HashMap;
import java.util.Map;

public class CountFrequecyOfWordinSentence {

    public static void main(String[] args) {
        String str = "Java Java Python C Java";
        Map<String, Integer> frequence = freqencyOfSentence(str);
        for(Map.Entry<String ,Integer> h: frequence.entrySet()){
            System.out.println(h.getKey()+ " " + h.getValue());
        }
    }

    private static Map<String, Integer> freqencyOfSentence(String str) {

        Map<String, Integer> hmap = new HashMap<>();
        String[] split = str.split("\\s+");
        for(String s: split){
            hmap.put(s, hmap.getOrDefault(s, 0)+1);
        }

        return hmap;
    }

}
