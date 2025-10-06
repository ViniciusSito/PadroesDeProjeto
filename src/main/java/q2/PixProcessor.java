package q2;

public class PixProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("PIX confirmado de R$ " + String.format("%.2f", amount));
    }
}


