import java.util.ArrayList;
import java.util.List;

public final class ImmutableExample {

    private final int i;
    private final List<Object> objects;

    public ImmutableExample(int i, List<Object> objects){
        this.i = i;
        this.objects = objects;
    }

    public int getInter(){
        return i;
    }

    public List<Object> getObjects(){
        return new ArrayList<>(objects);
    }

    @Override
    public String toString() {
        return "ImmutableExample{" +
                "i=" + i +
                ", objects=" + objects +
                '}';
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("shubham");
        list.add("kumar");
        ImmutableExample immutableExample = new ImmutableExample(1, list);
        immutableExample.getObjects().add("Gupta");
        immutableExample.getObjects().add("Hi");
        System.out.println(immutableExample);
    }
}
