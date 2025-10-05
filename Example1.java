import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {

    private int employeeId;
    private String name;
    private String department;
    private int salary;
    private int yearsOfExperience;

    public Example1(int employeeId, String name, String department, int salary, int yearsOfExperience) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Example1{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    public static void main(String[] args) {
        List<Example1> employees = new ArrayList<>();
        employees.add(new Example1(101, "Alice", "HR", 50000, 4));
        employees.add(new Example1(102, "Bob", "IT", 60000, 6));
        employees.add(new Example1(103, "Carol", "HR", 55000, 5));
        employees.add(new Example1(104, "David", "IT", 62000, 8));
        employees.add(new Example1(105, "Eva", "Finance", 70000, 7));

        //total number of employees
        long count = employees.stream().count();
        System.out.println(count);

        // averge salary of employees
        OptionalDouble average = employees.stream().mapToInt(emp -> emp.getSalary()).average();
        System.out.println(average);

        //max highesht salasy of employee
        int asInt = employees.stream().mapToInt(emp -> emp.getSalary()).max().getAsInt();
        System.out.println(asInt);

        Example1 example1 = employees.stream().max(Comparator.comparing(e -> e.getSalary())).get();
        System.out.println(example1);

        //find employee with experience more than 5
        long experienced = employees.stream().filter(e -> e.getYearsOfExperience() > 5).count();
        System.out.println(experienced);

        List<Example1> a = employees.stream().filter(e -> e.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println(a);

        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Example1::getDepartment, Collectors.counting()));
        System.out.println(collect);


        Map<String, Long> cc =employees.stream().collect(Collectors.groupingBy(Example1::getDepartment, Collectors.counting()));
//        Optional<Map.Entry<String, Long>> max = cc.entrySet().stream().max(Map.Entry.comparingByValue());
        Optional<Map.Entry<String, Long>> max = cc.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println(max.get());

    }
}
