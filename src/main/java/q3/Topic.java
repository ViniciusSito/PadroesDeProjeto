package q3;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject (tópico) que gerencia assinantes e notifica em novas publicações.
 *
 * Escolha de projeto (Q3): Observer desacopla publicador dos leitores.
 * O tópico não precisa saber quem é cada leitor nem como reagirá; basta
 * notificar a interface `Subscriber`.
 */
public class Topic {
    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public void subscribe(Subscriber s) {
        if (s != null && !subscribers.contains(s)) {
            subscribers.add(s);
        }
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void publish(String news) {
        for (Subscriber s : subscribers) {
            s.update(name, news);
        }
    }
}


