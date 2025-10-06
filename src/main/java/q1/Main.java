package q1;

public class Main {
    public static void main(String[] args) {
        ShippingStrategy road = new RoadShipping();
        double roadCost = road.calculate(150.0, 0.0, 0.0);
        System.out.println("Terrestre (150 km): R$ " + String.format("%.2f", roadCost));

        ShippingStrategy air = new AirShipping();
        double airCost = air.calculate(0.0, 12.5, 0.0);
        System.out.println("Aéreo (12.5 kg): R$ " + String.format("%.2f", airCost));

        ShippingStrategy sea = new SeaShipping();
        double seaCost = sea.calculate(0.0, 0.0, 3.2);
        System.out.println("Marítimo (3.2 m³): R$ " + String.format("%.2f", seaCost));
    }
}


