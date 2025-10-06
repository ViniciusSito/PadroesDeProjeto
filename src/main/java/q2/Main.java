package q2;

public class Main {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();

        PaymentProcessor card = factory.create(PaymentType.CREDIT_CARD);
        card.process(199.90);

        PaymentProcessor boleto = factory.create(PaymentType.BOLETO);
        boleto.process(359.50);

        PaymentProcessor pix = factory.create(PaymentType.PIX);
        pix.process(42.00);
    }
}


