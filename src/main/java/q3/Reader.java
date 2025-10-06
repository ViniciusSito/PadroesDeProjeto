package q3;

public class Reader implements Subscriber {
    private final String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String topic, String news) {
        System.out.println(name + " recebeu atualização em '" + topic + "': " + news);
    }
}


