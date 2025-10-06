package q2;

public class CardProcessor implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Pagamento com Cartão aprovado: R$ " + String.format("%.2f", amount));
    }
}


