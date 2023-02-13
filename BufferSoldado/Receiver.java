import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Buffer buffer;
    //private Cerveza cerveza;

    // standard constructors
    public Receiver(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (String receivedMessage = buffer.receive(); !"End".equals(receivedMessage); receivedMessage = buffer
                .receive()) {

                //System.out.println(receivedMessage);

            switch (receivedMessage) {
                case "EMPERADOR":
                    System.out.println("Toma tu cerveza Emperador");
                    break;
                case "SOLDADO":
                    System.out.println("Toma tu cerveza Soldado");
                    break;
                case "GENERAL":
                    System.out.println("Toma tu cerveza General");
                    break;

                default:
                    break;
            }
            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}