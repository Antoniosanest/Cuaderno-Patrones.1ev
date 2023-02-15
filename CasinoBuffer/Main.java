public class Main {

    public static void main(String[] args) {

        Player jugador1 = new Player(1);
        Player jugador2 = new Player(2);
        Player jugador3 = new Player(3);
        Player jugador4 = new Player(4);

        Banca juego_ruleta = new Banca();
        juego_ruleta.start();
        jugador1.start();
        jugador2.start();
        jugador3.start();
        jugador4.start();

    }

}
