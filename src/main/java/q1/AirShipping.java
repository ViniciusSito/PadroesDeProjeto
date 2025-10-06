package q1;

/**
 * Transporte aéreo: custo baseado em peso.
 *
 * Justificativa: outra variação do mesmo contrato, isolando o algoritmo
 * por herança. O cliente pode chamar calculate() sem conhecer detalhes.
 */
public class AirShipping extends ShippingStrategy {
    private static final double PRICE_PER_KG = 5.0; // R$/kg
    private static final double HANDLING_FEE = 30.0; // taxa fixa

    @Override
    public double calculate(double distanceKm, double weightKg, double volumeM3) {
        return HANDLING_FEE + (weightKg * PRICE_PER_KG);
    }
}


