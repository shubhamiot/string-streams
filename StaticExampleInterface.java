import java.awt.*;

public interface StaticExampleInterface {

    static void fly() {
        System.out.println("bird can fly");
    }
}
class StaticClass implements StaticExampleInterface{

    public void call(){
        StaticExampleInterface.fly();
    }

    public static void main(String args[]){
        StaticClass staticClass = new StaticClass();
        staticClass.call();
    }
}
