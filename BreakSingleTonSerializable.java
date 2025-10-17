import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.util.Arrays;

public class BreakSingleTonSerializable implements Serializable {

    private static BreakSingleTonSerializable instance ;

    public static BreakSingleTonSerializable getInstance(){
        if(instance == null){
            synchronized (BreakSingleTonSerializable.class){
                if(instance == null){
                    instance = new BreakSingleTonSerializable();
                }
            }
        }
        return instance;
    }

    public Object readResolve(){
        return instance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BreakSingleTonSerializable instance1 = getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d.txt"));
        objectOutputStream.writeObject(instance1);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d.txt"));
        BreakSingleTonSerializable o = (BreakSingleTonSerializable)objectInputStream.readObject();
        System.out.println(o.hashCode());

    }
}
