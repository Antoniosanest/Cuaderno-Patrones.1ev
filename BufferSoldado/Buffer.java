public class Buffer {
    // MENSAJE TIPO CADENA QUE COMPARTEN LOS HILOS
    private String packet;
    //private Cerveza cerveza;
   
    private boolean puedoRecibir = false;
    private boolean puedoEnviar = true;

    public synchronized void sender(String packet) {
        while (!puedoEnviar && puedoRecibir) {
            try {
                wait(); // alguien está recibiendo el mensaje
                //System.out.println("Espera, alguien está pidiendo una cerveza");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // EN CASO DE QUE PUEDA ENVIAR
        System.out.println("Soy el " + packet + " y quiero una cerveza.");
        puedoEnviar = false;
        puedoRecibir = true;
        this.packet = packet;
        //this.cerveza.setQuienMepide(nombre);
        notifyAll();
    }

    public synchronized String receive() {
        while (!puedoRecibir && puedoEnviar) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        puedoEnviar = true;
        puedoRecibir = false;
        String returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}
