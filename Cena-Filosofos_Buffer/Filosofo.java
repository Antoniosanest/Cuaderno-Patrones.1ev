public class Filosofo extends Thread {
    private Mesa mesa;
    private int comensal;
    private Buffer buffer;
    private int indiceVino;
    //CONSTRUCTOR CON EL BUFFER
    public Filosofo(Buffer buffer, Mesa m, int comensal) {
        this.mesa = m;
        this.comensal = comensal;
        this.buffer = buffer;
    }
    //GETTERS Y SETTERS QUE UTILIZAREMOS DESDE LA CLASE RECEIVER
    public int getIndiceVino() {
        return indiceVino;
    }

    public void setIndiceVino(int indiceVino1) {
        this.indiceVino = indiceVino1;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getComensal() {
        return comensal;
    }

    public void setComensal(int comensal) {
        this.comensal = comensal;
    }


    @Override
    public void run() {
        /* ¿Tiene aspecto de patrón? */
        while (true) {
            this.pensando(); // Piensan todos a la vez
            this.mesa.cogerTenedores(comensal); // Se pelean por los tenedores
            int indiceVino = this.mesa.cogerVino(); // Se pelean por el vino
            this.indiceVino = indiceVino; // Guardamos que vino han cogido para usarlo en el Receiver
            buffer.sender(this); // Mandamos la informacion de la Thread que haya entrado.
            this.mesa.dejarTenedores(comensal); // Dejamos los tenedores
            this.mesa.dejarVino(indiceVino); // Dejamos el vino

            /*
             * this.mesa.cogerTenedores(indiceComensal);
             * int indiceVino = this.mesa.cogerVino();
             * this.comiendo();
             * this.bebiendo();
             * 
             * System.out.println("Filosofo->" + comensal +
             * " deja de comer, tenedores libres "
             * + (this.mesa.tenedorIzquierda(indiceComensal) + 1) + ", "
             * + (this.mesa.tenedorDerecha(indiceComensal) + 1) + " .\n " + comensal
             * + " deja de beber , vino libre  " + indiceVino);
             * this.mesa.dejarVino(indiceVino);
             * 
             * this.mesa.dejarTenedores(indiceComensal);
             */

        }

    }

    public void comiendo() {
        System.out.println("Filósofo->" + comensal + " esta Comiendo. ");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pensando() {

        System.out.println("Filosofo->" + comensal + " Pensando. ");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void bebiendo() {

        System.out.println("Filosofo->" + comensal + " Bebiendo. ");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
