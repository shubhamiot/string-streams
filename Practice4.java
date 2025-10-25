public interface Practice4 {

    public static final Integer i = 2;

    public default String call() {
        return "ca";
    }

}

interface Practice5 {
    public default String call() {
        return "b";
    }
}

class Call implements Practice4, Practice5 {

    @Override
    public String call() {
        return Practice4.super.call();
    }

    public static void main(String[] args) {
        Call c = new Call();
        String call = c.call();
        System.out.println(call);
    }
}
