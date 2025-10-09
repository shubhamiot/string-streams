import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashSetExample {


    public static void main(String[] args) {

        Set<Integer> objects = Collections.synchronizedSet(new HashSet<>());
        objects.add(1);
        objects.add(2);
        Iterator<Integer> iterator = objects.iterator();
        while (iterator.hasNext())
        {
            int value = iterator.next();
            if(value == 2){
                objects.remove(2);
            }

        }
        objects.forEach((Integer i)-> System.out.println(i));


        Set<Integer> s = new TreeSet<>((a,b)-> b-a);
        s.add(23);
        s.add(34);
        s.add(12);
        s.add(2);
        s.forEach((Integer i) -> System.out.println("desc" + i));
    }
}
