public class Filosofo extends Thread{
    private Mesa mesa;
    private int comensal;

    public Filosofo(Mesa m, int comensal){
        this.mesa = m;
        this.comensal = comensal;
    }

    @Override
    public void run() {
        while(true){
            /*¿Tiene aspecto de patrón?*/
            this.pensando();
            this.mesa.cogerTenedores(comensal);
            this.comiendo();
            System.out.println("Filósofo->" + comensal  
                                    + " deja de comer, " +
                                    " tenedores libres:" + 
                                    (this.mesa.tenedorIzquierda(comensal))
                                    + ", "
                                    + (this.mesa.tenedorDerecha(comensal))
                            );
            this.mesa.dejarTenedores(comensal);
        }
        
    }
    public void comiendo(){
            System.out.println( "Filósofo->"+ comensal +" Comiendo. ");
            try {
                sleep((long) (Math.random() * 4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void pensando(){
        System.out.println( "Filósofo->"+ comensal +" Pensando. ");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
