import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Buffer buffer;

    // CONSTRUCTOR ESTANDAR DE LA CLASE, QUE VAN A HACER EL PAPEL DE LEONIDAS Y JERGES
    public Sender(Buffer buffer) {
        this.buffer = buffer;
    }

    //AQUI PONGO LOS SALUDOS, QUE ES LO QUE VA A SALIR EN PANTALLA CONSECUTIVAMENTE A MEDIDAD QUE EL RECEIVER RECIBA LOS MENSAJES
    public void run() {
        String packets[] = {
                "Hola Jerjes, soy Leonidas de Esparta y te saludo",
                "Jerjes recibe el saludo",
                "Hola Leonidas, soy Jerjes el Persa y te saludo",
                "Leonidas recibe el saludo",
                "Saludo completado",
                "End"
        };

        //EL END SE PONE PARA INDICARLE AL PROGRAMA QUE ACABE, Y QUE NO ESPERE MAS MENSAJES POR PARTE DEL SENDER.
        for (String packet : packets) {
            buffer.sender(packet);
            // Thread.sleep() PARA SIMULAR PROCESAMIENTO EN MS
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}