import java.util.*;

public class IterableExample {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.forEach((Integer i ) -> System.out.println(i));
        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("Using Iterator:" + next);
        }

        Collections.sort(l);
        Collections.rotate(l,2);
        System.out.println(l);
    }
}
