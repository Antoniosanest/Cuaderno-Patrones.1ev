class Pista {

    private Corredor c1;
    private Corredor c2;
    private Corredor c3;
    private Corredor c4;
    private Corredor c5;
    private int meta;
    public boolean hayGanador = false;

    public Pista(int meta) {
        this.meta = meta;
    }

    public int getMeta() {
        return meta;
    }

    public void setCorredores(Corredor c1, Corredor c2, Corredor c3, Corredor c4, Corredor c5) {
        c1.setPista(this);
        c2.setPista(this);
        c3.setPista(this);
        c4.setPista(this);
        c5.setPista(this);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
    }

    public void empezarCarrera() {
        
            c1.start();
            c2.start();
            c3.start();
            c4.start();
            c5.start();



    }

    public synchronized void cruzarMeta(Corredor corredor) {
        if(!hayGanador) {
            hayGanador = true;
            System.out.println("Corredor " + corredor.getNombre()+ " es el ganador");
            System.out.println("Carrera finalizada");

        }
    }

}
