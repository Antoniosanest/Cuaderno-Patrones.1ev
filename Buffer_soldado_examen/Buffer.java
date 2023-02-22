public class Buffer {
    // MENSAJE TIPO STRING QUE COMPARTEN LOS HILOS
    private String packet;

    //CREAMOS LOS BOOLEANOS QUE INDICAN SI EL SALUDO SE PUEDE ENVIAR O RECIBIR
    private boolean puedoRecibirSaludo = false;
    private boolean puedoEnviarSaludo = true;

    public synchronized void sender(String packet) {
        while (!puedoEnviarSaludo && puedoRecibirSaludo) {
            try {
                wait(); // SI LEONIDAS ENVIA EL MENSAJE CORRECTAMENTE Y JERGES LO RECIBE, 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // EN CASO DE QUE PUEDA ENVIAR
        puedoEnviarSaludo = false;
        puedoRecibirSaludo = true;

        this.packet = packet;
        notifyAll();
    }

    //COMO NECESITAMOS SYNCHRONIZE, CREAMOS LA CLASE  PUBLICA QUE HARA ESTA FUNCION
    public synchronized String receive() {

        //A CONTINUACION, LE INDICAREMOS CUANDO TIENE QUE ESPERAR Y NOTIFICAR SI SE CUMPLE EL WHILE
        
        while (!puedoRecibirSaludo && puedoEnviarSaludo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        puedoEnviarSaludo = true;
        puedoRecibirSaludo = false;
        String returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}