package q1;

/**
 * Transporte terrestre: custo baseado em distância.
 *
 * Justificativa: especializa o comportamento de cálculo (polimorfismo)
 * usando os dados relevantes ao modal (distância em km), sem afetar
 * outras modalidades.
 */
public class RoadShipping extends ShippingStrategy {
    private static final double PRICE_PER_KM = 1.25; // R$/km
    private static final double MINIMUM = 20.0;

    @Override
    public double calculate(double distanceKm, double weightKg, double volumeM3) {
        double cost = distanceKm * PRICE_PER_KM;
        return Math.max(cost, MINIMUM);
    }
}


