package q2;

public class BoletoProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Boleto gerado no valor de R$ " + String.format("%.2f", amount));
    }
}


