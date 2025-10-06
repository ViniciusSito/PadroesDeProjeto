package q1;

/**
 * Transporte marítimo: custo baseado em volume.
 *
 * Justificativa: mantém-se o mesmo uso polimórfico da classe base,
 * variando a lógica de cálculo de forma localizada.
 */
public class SeaShipping extends ShippingStrategy {
    private static final double PRICE_PER_M3 = 200.0; // R$/m3
    private static final double PORT_FEE = 50.0; // taxa portuária

    @Override
    public double calculate(double distanceKm, double weightKg, double volumeM3) {
        return PORT_FEE + (volumeM3 * PRICE_PER_M3);
    }
}


