public interface InterfaceExample {

    public void fly();
    public void noOfLegs();
}

abstract class Bird implements InterfaceExample{
    @Override
    public void fly() {
        System.out.println("bird can fly");
    }

    public abstract void canSpeak();
}

class Eagle extends Bird{

    @Override
    public void canSpeak() {
        System.out.println("Eagle can roar");
    }

    @Override
    public void noOfLegs() {
        System.out.println("eage have two leges");
    }

    public static void main(String[] args) {
        InterfaceExample interfaceExample = new Eagle();
        interfaceExample.fly();
        interfaceExample.noOfLegs();
        Bird b = new Eagle();
        b.canSpeak();
    }
}
