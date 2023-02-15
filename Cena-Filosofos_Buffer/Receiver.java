import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Buffer buffer;
    // private Cerveza cerveza;

    // standard constructors
    public Receiver(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (Filosofo receivedMessage = buffer.receive(); !"End".equals(receivedMessage); receivedMessage = buffer
                .receive()) { // El mensaje que va a recibir es de tipo Filosofo
            // MI DUDA AQUI, ES QUE ACCIONES TIENE QUE REALIZAR EL FILOSOFO DESDE AQUI, ¿TIENE QUE HACER TODO? O
            // SOLO ALGUNAS ACCIONES COMO POR EJEMPLO COMER Y BEBER
            //receivedMessage.pensando();
            //receivedMessage.getMesa().cogerTenedores(receivedMessage.getIndiceComensal());
            receivedMessage.comiendo(); // El Filosofo come
            //receivedMessage.getMesa().dejarTenedores(receivedMessage.getIndiceComensal());
            //int indiceVino = receivedMessage.getMesa().cogerVino();
            receivedMessage.bebiendo(); // el Filosofo bebe
            //receivedMessage.getMesa().dejarVino(indiceVino);
            System.out.println("Filosofo->" + receivedMessage.getComensal() + " deja de comer, tenedores libres "
                    + (receivedMessage.getMesa().tenedorIzquierda(receivedMessage.getComensal())) + ", "
                    + (receivedMessage.getMesa().tenedorDerecha(receivedMessage.getComensal())) + " .\n "
                    + receivedMessage.getComensal()
                    + " deja de beber , vino libre  " + receivedMessage.getIndiceVino());

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 7000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}