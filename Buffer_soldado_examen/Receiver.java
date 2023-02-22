import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Buffer buffer;
 
    // CONSTRUCTOR ESTANDAR PARA LA CLASE
    public Receiver(Buffer buffer){
        this.buffer = buffer;
    }

    //AQUI ES DONDE LE INDICAMOS QUE SI RECIBE "END" QUE PARE, MIENTRAS TANTO EL PROGRAMA SEGUIRÁ SALUDANDO
    public void run() {
        for(String receivedMessage = buffer.receive(); !"End".equals(receivedMessage);
         receivedMessage = buffer.receive()) {
            System.out.println(receivedMessage);


            //Thread.sleep() PONEMOS ESTO PARA SIMULAR PROCESAMIENTO EN MS MILISEGUNDOS
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));

                //SI SALTA EL CATCH, LO NOTIFICAMOS CON EL MENSAJE TRHEAD INTERRUPTED
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted"); 
            }
        }
    }
}