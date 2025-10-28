package lektion15.opgave6;

public class Car {

    private final String brand;
    private final String model;
    private final boolean electric;
    private final double pricePerDay;

    public Car(String brand, String model, boolean electric, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.electric = electric;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        String type = electric ? "Elbil" : "Benzin/Diesel";
        return String.format("%s %s - %s - %.2f kr. /dag",
                brand, model, type, pricePerDay);
    }

}
