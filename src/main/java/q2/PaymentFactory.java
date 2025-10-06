package q2;

/**
 * Factory Method responsável por instanciar o processador correto a partir do tipo.
 *
 * Escolha de projeto (Q2): o cliente apenas informa o tipo e recebe o
 * produto apropriado. Evita-se acoplamento com construtores concretos e
 * facilita a extensão de novos meios de pagamento sem alterar o cliente.
 */
public class PaymentFactory {
    public PaymentProcessor create(PaymentType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo");
        }
        switch (type) {
            case CREDIT_CARD:
                return new CardProcessor();
            case BOLETO:
                return new BoletoProcessor();
            case PIX:
                return new PixProcessor();
            default:
                throw new UnsupportedOperationException("Tipo não suportado: " + type);
        }
    }
}


