public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread soldado = new Thread(new Soldado(buffer, "SOLDADO"));
        Thread emperador = new Thread(new Emperador(buffer, "EMPERADOR"));
        Thread general = new Thread(new General(buffer, "GENERAL"));
        Thread receiver = new Thread(new Receiver(buffer));

        soldado.start();
        emperador.start();
        general.start();
        receiver.start();
       

    }

}
