import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Car {

    private String brand;
    private int age;
    private Set<String> parameters;

    public Car(String brand, int age, Set<String> parameters) {
        this.brand = brand;
        this.age = age;
        this.parameters = new HashSet<>(parameters);
    }

    public String getBrand() {
        return brand;
    }

    public int getAge() {
        return age;
    }

    public List<String> getParameters() {
        return new ArrayList<>(parameters);
    }
}