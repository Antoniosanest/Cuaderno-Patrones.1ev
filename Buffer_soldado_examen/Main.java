public class Main {
    public static void main(String[] args) {

        //PROGRAMA DE MENSAJERIA CON SYNCRONIZE, WAIT AND NOTIFY DE EL ESPARTANO LEONIDAS Y EL PERSA JERJES
        //PRIMERO SALUDARA LEONIDAS, JERJES ESPERARÁ A QUE LE LLEGUE EL SALUDO Y DESPUES ESTE LO SALUDARA DE VUELTA

        //INICIALIZAMOS EL BUFFER Y LAS DOS CLASES QUE VAN A COMUNICARSE

        Buffer buffer = new Buffer();

        //EL SENDER VAN A SER LOS QUE ENVIEN EL MENSAJE
        Thread sender = new Thread(new Sender(buffer));
        Thread receiver = new Thread(new Receiver(buffer));
        
        //LOS INICIAMOS
        sender.start();
        receiver.start();
    }
}
