import java.util.logging.Level;
import java.util.logging.Logger;

public class Participante extends Thread{
    private int distancia;
    private String nombre;
    private Pista pista;

    public Participante(String nombre) {
        this.distancia = 0;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {

            if(pista.hayGanador){ //wait() or/and notify()
                break;

                //sacamos por random el numero de pasos que da segun la bola decimos del 1 al 10
            }
            int random = (int) Math.floor(Math.random() * (1 - (10 + 1)) + (10));
            distancia += random;
            System.out.println("[" + nombre + "] Distancia = " + distancia + " pasos");
            if(distancia > pista.getMeta()) {
                pista.cruzarMeta(this);
                break;
            }
            try {
                sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getDistanciaRecorrida() {
        return this.distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }
}
