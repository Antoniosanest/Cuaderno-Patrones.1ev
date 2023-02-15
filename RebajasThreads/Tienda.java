class Tienda {

    private Comprador c1;
    private Comprador c2;
    private Comprador c3;
    private int existencias = 100;
    public boolean hayGanador = false;

    public int getexistencias() {
        return existencias;
    }

    public void setParticipantees(Comprador c1, Comprador c2, Comprador c3) {
        c1.setPista(this);
        c2.setPista(this);
        c3.setPista(this);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void empezarCompra() {

        c1.start();
        c2.start();
        c3.start();

    }

    // ANUNCIAMOS EL GANADOR Y FINALIZAMOS CARRERA

    public synchronized void agotarexistencias(Comprador Participante) {
        if (!hayGanador) {
            hayGanador = true;
            System.out.println("Los Iphone se han agotado y no quedan mas existencias");

        }
    }

}
