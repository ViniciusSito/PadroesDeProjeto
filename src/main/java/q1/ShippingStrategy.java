package q1;

/**
 * Classe base para cálculo de frete usando herança e polimorfismo.
 *
 * Escolha de projeto (Q1): como ainda não foi visto Strategy em aula,
 * usamos herança + polimorfismo: o código cliente lida com o tipo base
 * e cada modalidade sobrescreve o cálculo específico. Assim tratamos
 * genericamente transportes diferentes sem condicionais, mantendo o
 * código simples e aderente ao conteúdo estudado.
 */
public abstract class ShippingStrategy {
    public abstract double calculate(double distanceKm, double weightKg, double volumeM3);
}


