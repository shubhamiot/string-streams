import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pracrice2 {

    private String name;
    private String department;
    private double salary;

    public Pracrice2(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Pracrice2> employees = Arrays.asList(
                new Pracrice2("Alice", "IT", 70000),
                new Pracrice2("Bob", "HR", 50000),
                new Pracrice2("Charlie", "IT", 80000),
                new Pracrice2("David", "Finance", 75000),
                new Pracrice2("Eve", "IT", 90000),
                new Pracrice2("Frank", "HR", 60000)
        );

        String s = employees.stream()
                .collect(Collectors.groupingBy(c -> c.getDepartment(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(c -> c.getKey())
                .orElse(null);
        System.out.println(s);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5, 6);
        integers.parallelStream().forEach(integer -> System.out.println("parallel : " + integer));

        ForkJoinPool f = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> s1 = f.submit(() -> {
            System.out.println("s");
            return 2;
        });
        s1.get();

        ForkJoinTask<?> submit = f.submit(() -> integers.parallelStream().forEach(c -> System.out.println(c)));
        Object o = submit.get();
        System.out.println(o.toString());

        String department = employees.stream().collect(Collectors.groupingBy(c -> c.getDepartment(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(department);


        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,3,4), Arrays.asList(5,6,7), Arrays.asList(7,4));

        List<Integer> l = lists.stream()
                .flatMap(List::stream).collect(Collectors.toList());
        l.forEach(c -> System.out.println(c));
    }
}
