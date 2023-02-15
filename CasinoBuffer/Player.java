import java.util.Random;

public class Player extends Thread {
    private int id_player;
    // LOS JUGADORES SE DIFERENCIAN POR ID Y EMPIEZAN CON 1000 DE SALDO
    private int saldo = 1000;

    private Random generador = new Random();

    public Player(int id) {
        this.id_player = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getid_player() {
        return id_player;
    }

    public void setid_player(int id_player) {
        this.id_player = id_player;
    }

    @Override
    public void run() {

        // MIENTRAS TENGAN SALDO O LA BANCA NO ESTA EN BANCARROTA

        while (this.saldo != 0 && Banca.getSaldo() != 0) {

            int numRandom = generador.nextInt(36) + 1;

            System.out.println("Jugador " + id_player + " ha apostado al numero " + numRandom);

            // SI EL NUMERO GENERADO ES EL MISMO QUE EL QUE HA TOCADO EN EL RANODM
            if (numRandom == Banca.numGenerado) {
                System.out.println("Jugador " + id_player + " se lo lleva!");

                // le sumamos 360 veces lo apostado
                if (Banca.getSaldo() - 360 > 0) {
                    this.saldo = saldo + 360;
                    Banca.setSaldo(Banca.getSaldo() - 360);
                } else {
                    this.saldo = saldo + Banca.getSaldo();
                    Banca.setSaldo(0);
                }

                System.out.println("Saldo restante del jugador " + id_player + " = " + this.saldo);
            } else {
                System.out.println("Jugador " + id_player + " no se lo lleva, sigan intentando");

                // SE RESTA LOS 10 APOSTADOS AL JUGADOR (SI TIENE) Y SE SIGUE JUGANDO
                if (this.saldo - 10 >= 0) {
                    this.saldo = saldo - 10;
                } else {
                    Banca.setSaldo(Banca.getSaldo() + 10);
                }
                System.out.println("Saldo restante del jugador " + id_player + " = " + this.saldo);
            }

            // EL CROUPIER ESPERA 3000 MS PARA SACAR UN NUMERO AL AZAR DE NUEVO
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
