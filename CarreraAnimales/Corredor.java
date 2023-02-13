import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread{
    private int distancia;
    private String nombre;
    private Pista pista;

    public Corredor(String nombre) {
        this.distancia = 0;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            
            if(pista.hayGanador){ //wait() or/and notify()
                break;
            }
            int random = (int) Math.floor(Math.random() * (1 - (10 + 1)) + (10));
            distancia += random;
            System.out.println("[" + nombre + "] Ditancia = " + distancia + " m");
            if(distancia > pista.getMeta()) {
                pista.cruzarMeta(this);
                break;
            }
            try {
                sleep(800);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
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
