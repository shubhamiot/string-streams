import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(4);
//        Iterator<Integer> iterator = l.iterator();
//        while(iterator.hasNext()){
//            Integer value = iterator.next();
//            if(value.equals(l.get(1))){
//                l.remove(1);
//            }
//            System.out.println(value);
//        }

        Iterator<Integer> iterator = l.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            if(value == 3){
                l.remove(value);
            }
        }

        System.out.println(l);

    }
}
