import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleBreak {

    private static SingleBreak instance;

    private static SingleBreak getInstance(){
        if(instance == null){
            synchronized (SingleBreak.class){
                if(instance == null){
                    instance = new SingleBreak();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingleBreak instance1 = SingleBreak.getInstance();
        System.out.println(instance1);

        Constructor<SingleBreak> declaredConstructor = SingleBreak.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingleBreak singleBreak = declaredConstructor.newInstance();
        System.out.println(singleBreak.hashCode());


    }

}
