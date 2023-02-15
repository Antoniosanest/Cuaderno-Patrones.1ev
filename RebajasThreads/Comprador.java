import java.util.logging.Level;
import java.util.logging.Logger;

public class Comprador extends Thread {
    private int intentos;
    private String nombre;
    private Tienda pista;

    public Comprador(String nombre) {
        this.intentos = 0;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {

            if (pista.hayGanador) { // wait() or/and notify()
                break;

                // sacamos los intentos por random y se llevan los iPhone
            }
            int random = (int) Math.floor(Math.random() * (1 - (10 + 1)) + (10));
            intentos += random;
            System.out.println("[" + nombre + "] lo intentan y en total se han llevado = " + intentos + " iPhone");
            if (intentos > pista.getexistencias()) {
                pista.agotarexistencias(this);
                break;
            }
            try {
                sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Comprador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getintentosRecorrida() {
        return this.intentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPista(Tienda pista) {
        this.pista = pista;
    }
}
