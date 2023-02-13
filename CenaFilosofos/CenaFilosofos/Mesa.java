public class Mesa{
    private boolean[] tenedores;

    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzquierda(int comensal){
        return comensal;
    }
    public int tenedorDerecha(int comensal){
        if(comensal==1){
            return this.tenedores.length;
        }else{
            return comensal;
        }
    }

    public synchronized void cogerTenedores(int comensal){
        boolean izquierda = tenedores[tenedorIzquierda(comensal)-1];
        boolean derecha = tenedores[tenedorDerecha(comensal)-1];

        // TENEDORES OCUPADOS
        while(izquierda || derecha){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // O TENEDORES LIBRES
        tenedores[tenedorIzquierda(comensal)-1] = true;
        tenedores[tenedorDerecha(comensal)-1] = true;
    }
    public synchronized void dejarTenedores(int comensal){
        tenedores[tenedorIzquierda(comensal)-1] = false;
        tenedores[tenedorDerecha(comensal)-1] = false;
         notifyAll();
        
    }
}