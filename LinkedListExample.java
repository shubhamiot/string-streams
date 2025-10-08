import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addFirst(1);

        for(Integer itr : l){
            System.out.println(itr);
        }



    }
}
