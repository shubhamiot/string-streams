public interface DefaultExample {

    public abstract void fly();
    public default void noOfLegs(){
        System.out.println("4");
    }
}

 interface DefaultExample1 {

    public void fly();
    public default void noOfLegs(){
        System.out.println("5");
    }
}

class A implements DefaultExample, DefaultExample1{

    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void noOfLegs() {
//        DefaultExample1.super.noOfLegs();
        System.out.println("6");
    }

    public static void main(String[] args) {
        DefaultExample d = new A();
        d.fly();
        d.noOfLegs();
    }
}
