import java.util.concurrent.ThreadLocalRandom;

public class Soldado implements Runnable {
    private Buffer buffer;
    private String nombre;
    //private Cerveza cerveza = new Cerveza(nombre);

    // standard constructors
    public Soldado(Buffer buffer, String nombre) {
        this.buffer = buffer;
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void run() {
        // for (String packet : packets) {
            
        buffer.sender(getNombre());
        //this.cerveza.setQuienMepide(nombre);
        // Thread.sleep() to mimic heavy server-side processing
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted");
        }
        // }
    }
}
