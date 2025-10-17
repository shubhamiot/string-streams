import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Executors;

public class Car {

    private String firstName;
    private String lastName;

    public Car(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args){

        Car[] c = new Car[3];
        c[0] = new Car("shubham", "gupta");
        c[1] = new Car("shubham", "debey");
        c[2] = new Car("rakesh", "m");

        Arrays.sort(c, (Car a, Car b) -> b.getFirstName().compareTo(a.getFirstName()));
        for(Car c1 : c){
            System.out.println(c1.getFirstName() + " " + c1.getLastName());
        }
    }
}
