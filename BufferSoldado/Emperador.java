import java.util.concurrent.ThreadLocalRandom;

public class Emperador implements Runnable {
    private Buffer buffer;
    private String nombre;

    // standard constructors
    public Emperador(Buffer buffer, String nombre) {
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

        buffer.sender(getNombre());

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
