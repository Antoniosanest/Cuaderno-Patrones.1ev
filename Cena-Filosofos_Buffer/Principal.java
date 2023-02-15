public class Principal {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread receiver = new Thread(new Receiver(buffer));
        Mesa mesa = new Mesa(5, 2);
        // int random = (int) Math.random() * 5;
        // Inicializo los filosofos de esta manera, ya si los declaro dentro del for,
        // creará un reciever por cada iteracion
        // He encontrado dos soluciones, hacerlo de esta manera o sacar el receiver del
        // for y llamar a estar arriba del mismo, mas abajo está el ejemplo comentado
        /*
         * Filosofo f1 = new Filosofo(buffer, mesa, 1);
         * Filosofo f2 = new Filosofo(buffer, mesa, 2);
         * Filosofo f3 = new Filosofo(buffer, mesa, 3);
         * Filosofo f4 = new Filosofo(buffer, mesa, 4);
         * Filosofo f5 = new Filosofo(buffer, mesa, 5);
         * f1.start();
         * f2.start();
         * f3.start();
         * f4.start();
         * f5.start();
         * receiver.start();
         */

        receiver.start();
        for (int i = 1; i <= 5; i++) {
            Filosofo f = new Filosofo(buffer, mesa, i);
            f.start();
        }

    }
}
