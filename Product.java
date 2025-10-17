import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {

    private long salary;
    private String name;

    public Product(long salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString()
    {
        return salary+ " " + name;
    }

    public static void main(String[] args) {
        List<Product> list = Arrays.asList(new Product(200, "shubam"), new Product(300, "gupta"), new Product(100, "kt"),
                new Product(100, "rupa"), new Product(200, "rakesh"));
        List<Product> decending = list.stream().sorted(Comparator.comparing(Product::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(decending);

        Map<Long, List<Product>> collect = list.stream().collect(Collectors.groupingBy(c -> c.getSalary()));
        collect.forEach((a,b)-> System.out.println(a + ""+b));
    }
}
