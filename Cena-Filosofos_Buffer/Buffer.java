public class Buffer {
    // MENSAJE TIPO CADENA QUE COMPARTEN LOS HILOS
    private Filosofo packet;
   
    private boolean puedoRecibir = false;
    private boolean puedoEnviar = true;

    public synchronized void sender(Filosofo packet) { // LLega la informacion de la Thread que envia encapsulada en la clase Filosofo
        while (!puedoEnviar && puedoRecibir) {
            try {
                wait(); // alguien está recibiendo el mensaje
                //System.out.println("El Filósofo -> "+ packet.getName() +" pide comer o beber.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // EN CASO DE QUE PUEDA ENVIAR
        puedoEnviar = false;
        puedoRecibir = true;
        this.packet = packet; // Guardamos el Filosofo que quiere enviar

        notifyAll();
    }

    public synchronized Filosofo receive() {
        while (!puedoRecibir && puedoEnviar) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        puedoEnviar = true;
        puedoRecibir = false;
        Filosofo returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}
