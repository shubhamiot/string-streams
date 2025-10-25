import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<ComparableExample>{

    private int id;
    private String name;
    private Double salary;

    public ComparableExample(int id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    @Override
    public int compareTo(ComparableExample o) {
        return Double.compare(this.salary, o.salary);
    }

    public static void main(String[] args){
        List<ComparableExample> list = Arrays.asList(new ComparableExample(1,"shubham", 2000.0),
                new ComparableExample(2,"shiva", 30000000.0), new ComparableExample(3,"ashwini", 30000.0));
        list.sort((a,b)-> b.getSalary().compareTo(a.getSalary()));

        for(ComparableExample c : list){
            System.out.println(c.salary);
        }


    }
}
