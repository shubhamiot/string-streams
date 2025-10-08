import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueueExample{

    public static void main(String[] args) {
        Queue<Integer> a = new PriorityQueue<>();
        a.add(1);
        a.offer(2);
        a.offer(3);
        a.offer(4);
        a.forEach((Integer i) -> System.out.println(i));
        Queue<Integer> p1 = new PriorityQueue<>((a1,b2)-> b2-a1);
        p1.add(5);
        p1.add(2);
        p1.add(8);
        p1.add(1);
        p1.forEach((Integer i) -> System.out.println(i));

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, null); // hascode 0
        map.put(null,1);  //hascode 1
        System.out.println("hascode " + map.hashCode());

        List<String> list = Arrays.asList(null, "banana");
//        Collections.sort(list);
        Comparator.nullsFirst(Comparator.naturalOrder());
    }
}
