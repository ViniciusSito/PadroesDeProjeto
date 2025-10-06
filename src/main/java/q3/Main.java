package q3;

public class Main {
    public static void main(String[] args) {
        Topic politics = new Topic("política");
        Topic sports = new Topic("esportes");

        Reader alice = new Reader("Alice");
        Reader bob = new Reader("Bob");
        Reader carol = new Reader("Carol");

        politics.subscribe(alice);
        politics.subscribe(bob);
        sports.subscribe(bob);
        sports.subscribe(carol);

        politics.publish("Reforma aprovada no congresso");
        sports.publish("Time X vence campeonato");
    }
}


