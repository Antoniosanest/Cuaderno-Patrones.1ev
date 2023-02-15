import java.util.Random;

public class Banca extends Thread {

    private static int saldo = 50000;
    private static Random generador = new Random();
    public static int numGenerado;

    @Override
    public void run() {

        while (saldo != 0) {

            generarNumero();
            // EL CROUPIER ESPERA 3000 MS PARA SACAR UN NUMERO AL AZAR DE NUEVO
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Banca.saldo = saldo;
    }

    public static void generarNumero() {
        int numGenerado = generador.nextInt(37);
        Banca.numGenerado = numGenerado;
    }

}
