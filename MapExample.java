import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("shubh", "gupta");
        map.put("manju", "dg");

        System.out.println(map);
        for(Map.Entry<String , String > m : map.entrySet()){
            System.out.println("key"+ m.getKey() + "value" + m.getValue());
        }

        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
        integerIntegerTreeMap.put(1,2);
        integerIntegerTreeMap.put(2,3);
        integerIntegerTreeMap.put(3,5);
        integerIntegerTreeMap.forEach((a,b)-> System.out.println(a + " "+b));
    }
}
