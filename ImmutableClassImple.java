import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ImmutableClassImple {

    private final String name;
    private final List<String> book;

    public ImmutableClassImple(String name, List<String> book){
        this.name = name;
        this.book = List.copyOf(book);
    }

    public String getName(){
        return name;
    }

    public List<String> getBook(){
        return book;
    }

    public static void main(String[] args) {
        ImmutableClassImple immutableClassImple = new ImmutableClassImple("shubham", Arrays.asList("johnson"));
        List<String> book1 = immutableClassImple.getBook();
        book1.add("h");
        System.out.println(immutableClassImple);
    }
}
