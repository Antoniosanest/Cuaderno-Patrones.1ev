import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
    private boolean[] tenedores; //ARRAY QUE GUARDA LOS TENEDORES
    private boolean[] vino; //ARRAY QUE GUARDA LOS VINOS

    public Mesa(int numTenedores, int numVino) {
        this.tenedores = new boolean[numTenedores];
        this.vino = new boolean[numVino];
        this.vino[0] = false; //INICIAMOS LOS DOS VINOS A FALSE, YA QUE ESTAN DESOCUPADOS
        this.vino[1] = false;
    }

    public int tenedorIzquierda(int comensal) {
        
            return comensal;
        
    }

    public int tenedorDerecha(int comensal) {
        if (comensal == 1) {
            return this.tenedores.length;
        } else {
            return comensal;
        }
    }

    public synchronized int cogerVino() {
        boolean vino1 = vino[0]; // 1ª VINO
        boolean vino2 = vino[1]; // 2ª VINO

        while (vino1 && vino2) { // Si estan los dos a true, esperas, ya que alguien esta bebiendo
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // algún vino libre
        if (vino1 == false) {
            vino[0] = true;
            return 0; // devolvemos el vino que cogemos
        } else {
            vino[1] = true;
            return 1; // devolvemos el vino que cogemos
        }
    }

    public synchronized void dejarVino(int indiceVino) {

        if (indiceVino == 0) { // Sabemos cual hemos escogido, ya que cuando cogemos el Vino, devolvemos su posicion.
            vino[0] = false;
        } else {
            vino[1] = false;
        }
        notifyAll();
    }

    public synchronized void cogerTenedores(int comensal) {

        
        boolean izquierda = tenedores[tenedorIzquierda(comensal) - 1];
        boolean derecha = tenedores[tenedorDerecha(comensal) - 1];
        // TENEDORES OCUPADOS
        while (izquierda || derecha) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TENEDORES LIBRES
        tenedores[tenedorIzquierda(comensal) - 1] = true;
        tenedores[tenedorDerecha(comensal) - 1] = true;
    }

    public synchronized void dejarTenedores(int comensal) {
        tenedores[tenedorIzquierda(comensal) - 1] = false;
        tenedores[tenedorDerecha(comensal) - 1] = false;
        notifyAll();
    }
}
