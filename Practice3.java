import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Practice3 {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Practice3(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - " + salary;
    }
    public static void main(String[] args) {

       List<List<Integer>>  lists = Arrays.asList(Arrays.asList(1,2,3,4), Arrays.asList(3,5,6), Arrays.asList(5,6,7));

        List<Integer> collect = lists.stream()
                .flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);

        // find the word having 2 vowel in it
        String s = "shubham kumar gupta java is good";
        String[] split = s.split("\\s+");
        List<String> collect1 = Arrays.stream(split).filter(c -> countV(c) == 2).collect(Collectors.toList());
        System.out.println("count vowel = " + collect1);


        String string = "Shubham Kumar Gupta";
        String[] split1 = string.split("\\s+");
        Arrays.stream(split1).filter(c -> c.startsWith("a")).collect(Collectors.toList());

        Map<Integer, Integer> integerIntegerMap = Map.of(1, 2, 3, 5);
        for(Map.Entry<Integer, Integer> m  : integerIntegerMap.entrySet()){
            System.out.println(m.getKey() + " "  + m.getValue());
        }

        // below code with give unmodifiableOperation Exception
//        Map<Integer, Integer> integerIntegerMap1 = Collections.unmodifiableMap(integerIntegerMap);
//        integerIntegerMap1.put(6,7);
//        for(Map.Entry<Integer, Integer> m  : integerIntegerMap1.entrySet()){
//            System.out.println(m.getKey() + " "  + m.getValue());
//        }

        String s1 = voidSwitch();
        System.out.println("switch"+ s1);

        List<Integer> arr = List.of(1,2,4,5,6);
        List<Integer> collect2 = arr.stream().map(c -> c * c).collect(Collectors.toList());
        System.out.println(collect2);

        List<Integer> integers = List.of(1, 3, 4, 5);
        Optional<Integer> first = integers.stream().sorted(Comparator.comparingInt(c -> (int) c).reversed()).skip(1).findFirst();
        System.out.println("secong largest:" + first.get());


        List<Practice3> employees = Arrays.asList(
                new Practice3(1, "Alice", "IT", 60000),
                new Practice3(2, "Bob", "HR", 50000),
                new Practice3(3, "Charlie", "IT", 70000),
                new Practice3(4, "David", "Finance", 65000),
                new Practice3(5, "Eve", "HR", 55000),
        new Practice3(6, "Ev", "HR", 55000)
        );

        //find emplyee with uniques salary
        List<Double> collect3 = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getSalary(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(c -> c.getKey())
                .collect(Collectors.toList());
        System.out.println(collect3);

        // unique employee with salary
        List<Practice3> collect4 = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getSalary()))
                .values()
                .stream()
                .filter(c -> c.size() == 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        for(Practice3 p : collect4){
            System.out.println("uniq" + p.getId()+ " " + p.getSalary() + " " + p.getName());
        }

        // distinct salary
        List<Double> collect5 = employees.stream()
                .map(c -> c.getSalary())
                .distinct()
                .collect(Collectors.toList());

        for(Double d : collect5){
            System.out.println("distict salary:"+ d);
        }

        // count employee with department

        Map<String, Long> collect6 = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getDepartment(), Collectors.counting()));
        for(Map.Entry<String, Long> map : collect6.entrySet()){
            System.out.println("count employee" + map.getKey() + " " + map.getValue());

        }

        //max salary in each department
        Map<String, Optional<Practice3>> collect7 = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getDepartment(), Collectors.maxBy(Comparator.comparingDouble(c -> c.getSalary()))));
        for(Map.Entry<String, Optional<Practice3>> maxDep : collect7.entrySet()){
            System.out.println("max salary in each deparment" + maxDep.getKey() + " " + maxDep.getValue());
        }

        // find the name of emp in each department, where salary in range

        Map<String, List<Practice3>> collect8 = employees.stream()
                .filter(c -> c.getSalary() > 40000.0 && c.getSalary() < 70000.0)
                .collect(Collectors.groupingBy(c -> c.getDepartment()));

        for(Map.Entry<String, List<Practice3>> map : collect8.entrySet()){
            System.out.println("salary in range"+ map.getKey() +  "  " + map.getValue());
        }
        Map<Double, Long> collect9 = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getSalary(), Collectors.counting()));
        List<Double> collect10 = collect9.entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("dfdf" + collect10);

//        Set<Double> doubles = collect9.keySet();
//        System.out.println("do" + doubles);

    }

    private static String voidSwitch() {

        String s = "s";
        return switch (s){
            case "s" -> "shubham";
            case "v" -> "kumar";
            default -> null;
        };

    }

    private static long countV(String c) {
        return c.chars()
                .filter(c2 -> "aeiou".indexOf(c2)!=-1).count();

    }

}
